package com.pinapoll.controllers;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;
import com.pinapoll.models.User;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.ResponseServiceImpl;
import com.pinapoll.services.UserServiceImpl;


@Controller
public class PollController {

	@Autowired
    private UserServiceImpl userService;
	
	@Autowired
    private PollServiceImpl pollService;
	
	@Autowired
    private ResponseServiceImpl responseService;
	
    @GetMapping("/poll/create")
    public ModelAndView pollCreation() {

    	ModelAndView modelAndView = new ModelAndView();
        Poll poll = new Poll();
        modelAndView.addObject("poll", poll);
        modelAndView.setViewName("poll-creation");
        return modelAndView;
    }
    
    @RequestMapping(value = "/poll/create", method = RequestMethod.POST)
    public ModelAndView addFruits(@Valid Poll poll, BindingResult bindingResult, Authentication authentication, 
    							  @RequestParam("response") List<String> responses) {
      	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        User user = userService.findUserByName(authentication.getName());
        poll.setUser(user);
        
        int countResponse = 0;
        for(String resp : responses) { if(!resp.equals("")) countResponse++; }
        
        // Question controls
        if (poll.getQuestion().equals("")) {
        	bindingResult.rejectValue("question", "error.poll", "* You must enter a question");
        }
        
        if (countResponse < 2 || countResponse > 10) {
        	bindingResult.rejectValue("responses", "error.poll", "* You must have between two and ten responses");
        }

        // Routing
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("poll-creation");
        } else {
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
    	List<Response> responses = responseService.getResponsesForPoll(poll);
    	
    	modelAndView.addObject("poll", poll);
    	modelAndView.addObject("responses", responses);
        modelAndView.setViewName("poll");
        return modelAndView;
    }
    
    @GetMapping("/poll/delete/{id}")
    public ModelAndView deletePoll(Model model, @PathVariable("id") int id, Authentication authentication) {
    	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        User user = userService.findUserByName(authentication.getName());
        Poll poll = pollService.getPoll(id);
        
        if(user.getName().equals(poll.getUser().getName())) {
        	pollService.deletePoll(poll);
        }

        modelAndView.setViewName("redirect:/user/" + user.getName());
        return modelAndView;
    }
    
}
