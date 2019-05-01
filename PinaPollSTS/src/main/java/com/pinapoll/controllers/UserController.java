package com.pinapoll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.User;
import com.pinapoll.services.UserService;

@Controller
public class UserController {
	
	 @Autowired
    private UserService userService;

    @GetMapping("/user/{name}")
    public ModelAndView detailBet(Model model, @PathVariable("name") String name, Authentication authentication) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	User user = userService.findUserByName(name);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
    
}
