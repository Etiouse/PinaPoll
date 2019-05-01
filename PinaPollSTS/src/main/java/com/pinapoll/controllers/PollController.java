package com.pinapoll.controllers;

import java.util.List;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;
import com.pinapoll.models.User;
import com.pinapoll.services.PollService;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.ResponseServiceImpl;
import com.pinapoll.services.UserService;


@Controller
public class PollController {

	@Autowired
    private PollServiceImpl pollService;
	
	@Autowired
    private ResponseServiceImpl responseService;
	
    @GetMapping("/create")
    public ModelAndView pollCreation() {
        
    	ModelAndView modelAndView = new ModelAndView();
        Poll poll = new Poll();
        modelAndView.addObject("poll", poll);
        modelAndView.setViewName("poll-creation");
        return modelAndView;
    }
    
    @PostMapping(value = "/create")
    public String createNewPoll(@Valid Poll poll, BindingResult bindingResult) {
    	
        return "poll-creation";
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
    
    /*@PostMapping(params = "answer")
    public String answerPoll(HttpServletRequest request) {
    	System.out.println("Hello there");
        return "/";
    }*/
    
}
