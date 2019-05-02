package com.pinapoll.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Category;
import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;
import com.pinapoll.models.User;
import com.pinapoll.models.UserResponse;
import com.pinapoll.pojo.PollPojo;
import com.pinapoll.services.CategoryServiceImpl;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.ResponseServiceImpl;
import com.pinapoll.services.UserResponseServiceImpl;
import com.pinapoll.services.UserServiceImpl;


@Controller
public class PollController {

	@Autowired
    private UserServiceImpl userService;
	
	@Autowired
    private PollServiceImpl pollService;
	
	@Autowired
    private ResponseServiceImpl responseService;
	
	@Autowired
    private UserResponseServiceImpl userResponseService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
    @GetMapping("/poll/create")
    public ModelAndView pollCreation() {

    	ModelAndView modelAndView = new ModelAndView();
        
    	PollPojo pollPojo = new PollPojo();
        List<Category> categories = categoryService.getAll();
        
        modelAndView.addObject("pollPojo", pollPojo);
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("poll-creation");
        return modelAndView;
    }
    
    @RequestMapping(value = "/poll/create", method = RequestMethod.POST)
    public ModelAndView addFruits(@Valid PollPojo pollPojo, BindingResult bindingResult, Authentication authentication,
    							  @RequestParam("response") List<String> responses,
    							  @RequestParam("select_category") String value) {
      	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        User user = userService.findUserByName(authentication.getName());
        Category cat = categoryService.getWithName(value);

        pollPojo.setUser(user);
        pollPojo.setCategory(cat);
        
        int countResponse = 0;
        for(String resp : responses) { if(!resp.equals("")) countResponse++; }
        
        // Question controls
        if (pollPojo.getQuestion().equals("")) {
        	bindingResult.rejectValue("question", "error.poll", "* You must enter a question");
        }
        
        if (countResponse < 2 || countResponse > 10) {
        	bindingResult.rejectValue("responses", "error.poll", "* You must have between two and ten responses");
        }

        // Routing
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("poll-creation");
        } else {
        	Poll poll = new Poll();
        	poll.setCategory(pollPojo.getCategory());
        	poll.setQuestion(pollPojo.getQuestion());
        	poll.setResponses(pollPojo.getResponses());
        	poll.setUser(pollPojo.getUser());
        	
            pollService.savePoll(poll);
            
            for(String resp : responses) {    	
            	if(!resp.equals("")) {
            		Response r = new Response();
                	r.setDescription(resp);
                	r.setPoll(poll);
                	responseService.saveResponse(r);
            	}
            }
            
            modelAndView.addObject("poll", new Poll());
            modelAndView.setViewName("redirect:/user/" + user.getName());
        }
        
        return modelAndView;
    }
    
    @GetMapping("/poll/{id}")
    public ModelAndView detailPoll(Model model, @PathVariable("id") int id, Authentication authentication) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	Poll poll = pollService.getPoll(id);
    	User userConnected = userService.findUserByName(authentication.getName());
    	List<Response> responses = responseService.getResponsesForPoll(poll);
    	
    	modelAndView.addObject("poll", poll);
    	modelAndView.addObject("responses", responses);
        modelAndView.setViewName("poll");

        // get answer if already answered
        boolean answered = false;
        String answer = "";
        
        for(Response r : poll.getResponses()) { 
        	if(userResponseService.userResponseExist(userConnected, r)) {
        		answered = true;
        		answer = r.getDescription();
        	}
        }
               
        modelAndView.addObject("answer", answer);
        modelAndView.addObject("answered", answered);

        // get all answers for the poll
        List<String> responsesDescription = new ArrayList<>();
        List<Integer> nbAnswers = new ArrayList<>();
        for (Response response : responses)
        {
        	responsesDescription.add(response.getDescription());
        	nbAnswers.add(0);        	
        }
        
        List<UserResponse> userResponses = userResponseService.respongetAllResponseWithPollId(id);
        
        for (int i = 0; i < userResponses.size(); i++)
        {
        	int index = responses.indexOf(userResponses.get(i).getResponse());
        	nbAnswers.set(index, nbAnswers.get(index) + 1);
        }
       
    	modelAndView.addObject("questions", responsesDescription);
    	modelAndView.addObject("nbAnswers", nbAnswers);
    	
        return modelAndView;
    }
    
    @PostMapping(value = "/poll/{id}")
    public ModelAndView answerPoll(Model model, @PathVariable("id") int id, Authentication authentication, @RequestParam("radioAnswer") String answer) {
    	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        Poll poll = pollService.getPoll(id);
        List<Response> responses = poll.getResponses();
        
        User user = userService.findUserByName(authentication.getName());
        Response response = null;
        for (int i = 0; i < responses.size(); i++) {
        	if (responses.get(i).getDescription().equals(answer)) {
        		response = responses.get(i);
        	}
        }

    	UserResponse userResponse = new UserResponse();
        if (user != null && response != null) {
        	userResponse.setUser(user);
        	userResponse.setResponse(response);
            userResponseService.saveUserResponse(userResponse);
        }

        modelAndView.setViewName("redirect:/poll/" + id);
        return modelAndView;
    }
    
    @GetMapping("/poll/delete/{id}")
    public ModelAndView deletePoll(Model model, @PathVariable("id") int id, Authentication authentication) {
    	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        Poll poll = pollService.getPoll(id);
        modelAndView.setViewName("redirect:/user/" + poll.getUser().getName());
        
        if(authentication == null) {
        	return modelAndView;
        }
        
        User user = userService.findUserByName(authentication.getName());
        
        if(user.getName().equals(poll.getUser().getName()) || user.getActive() == 2) {
        	pollService.deletePoll(poll);
        }
        
        return modelAndView;
    }
    
}
