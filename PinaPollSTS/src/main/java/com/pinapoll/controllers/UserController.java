package com.pinapoll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;
import com.pinapoll.models.User;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private PollServiceImpl pollService;

    @GetMapping("/user/{name}")
    public ModelAndView detailUser(Model model, @PathVariable("name") String name, Authentication authentication) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	User user = userService.findUserByName(name);
    	User connected = userService.findUserByName(authentication.getName());
    	List<Poll> polls = pollService.getPollWithUser(user);

    	boolean canCreate = authentication!=null && connected.getName().equals(user.getName());
    	boolean canDelete = canCreate || connected.getActive() == 2;
    	
        modelAndView.addObject("user", user);
        modelAndView.addObject("polls", polls);
        modelAndView.addObject("can_create", canCreate);
        modelAndView.addObject("can_delete", canDelete);
        
        modelAndView.setViewName("profile");
        return modelAndView;
    }
    
}
