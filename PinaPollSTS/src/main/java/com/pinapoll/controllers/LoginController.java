package com.pinapoll.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.User;
import com.pinapoll.repositories.UserRepository;
import com.pinapoll.services.UserService;

import java.util.regex.Pattern;

@Controller
public class LoginController {
	
	private final String REGISTRATION = "registration";
	private final String ERROR_USER = "error.user";
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
	   
    // Redirect the user to the login
	@GetMapping(value= "/login")
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
        modelAndView.setViewName(REGISTRATION);
        
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
            bindingResult.rejectValue("name", ERROR_USER, "*Name already taken");
        }
        if (user.getName().length() < 4 && user.getName().length() != 0) {
        	bindingResult.rejectValue("name", ERROR_USER, "*Name must contains at least 4 characters");
        }
        if (user.getName().length() > 20 && user.getName().length() != 0) {
        	bindingResult.rejectValue("name", ERROR_USER, "*Name must contains a maximum of 20 characters");
        }
        
        // Email controls
        User userMailExists = userRepository.findByEmail(user.getEmail());
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
        if (userMailExists != null) {
        	bindingResult.rejectValue("email", ERROR_USER, "*There is already a user registered with that email");
        }
        Pattern pat = Pattern.compile(emailRegex); 
        if (!pat.matcher(user.getEmail()).matches() && user.getEmail().length() != 0) {
        	bindingResult.rejectValue("email", ERROR_USER, "*Email invalid");
        }
        
        // Password controls
        if (user.getPassword().length() < 4 && user.getPassword().length() != 0) {
        	bindingResult.rejectValue("password", ERROR_USER, "*Password must contains at least 4 characters");
        }
        if (user.getPassword().length() > 20 && user.getPassword().length() != 0) {
        	bindingResult.rejectValue("password", ERROR_USER, "*Password must contains a maximum of 20 characters");
        }
        
        // Routing
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(REGISTRATION);
        } else {
            userService.saveUser(user);
            modelAndView.addObject("success", true);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName(REGISTRATION);

        }
        
        return modelAndView;
    }
}
