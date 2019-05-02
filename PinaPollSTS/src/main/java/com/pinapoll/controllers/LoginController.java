package com.pinapoll.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.User;
import com.pinapoll.repositories.UserRepository;
import com.pinapoll.services.UserService;

import java.util.regex.Pattern;

@Controller
public class LoginController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
	   
    // Redirect the user to the login
	@RequestMapping(value= {"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	// Redirect the user to the registration
    @GetMapping(value="/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        
        return modelAndView;
    }
    
    // Create the user from the registration inputs (if valid)
    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
    	
    	// Model and View
        ModelAndView modelAndView = new ModelAndView();
        
        // Name controls
        User userNameExists = userService.findUserByName(user.getName());
        if (userNameExists != null) {
            bindingResult.rejectValue("name", "error.user", "*Name already taken");
        }
        if (user.getName().length() < 4 && user.getName().length() != 0) {
        	bindingResult.rejectValue("name", "error.user", "*Name must contains at least 4 characters");
        }
        if (user.getName().length() > 20 && user.getName().length() != 0) {
        	bindingResult.rejectValue("name", "error.user", "*Name must contains a maximum of 20 characters");
        }
        
        // Email controls
        User userMailExists = userRepository.findByEmail(user.getEmail());
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
        if (userMailExists != null) {
        	bindingResult.rejectValue("email", "error.user", "*There is already a user registered with that email");
        }
        Pattern pat = Pattern.compile(emailRegex); 
        if (!pat.matcher(user.getEmail()).matches() && user.getEmail().length() != 0) {
        	bindingResult.rejectValue("email", "error.user", "*Email invalid");
        }
        
        // Password controls
        if (user.getPassword().length() < 4 && user.getPassword().length() != 0) {
        	bindingResult.rejectValue("password", "error.user", "*Password must contains at least 4 characters");
        }
        if (user.getPassword().length() > 20 && user.getPassword().length() != 0) {
        	bindingResult.rejectValue("password", "error.user", "*Password must contains a maximum of 20 characters");
        }
        
        // Routing
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("success", true);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        
        return modelAndView;
    }
}
