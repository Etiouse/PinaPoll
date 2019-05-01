package com.pinapoll.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;


@Controller
public class PollController {

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
    
}
