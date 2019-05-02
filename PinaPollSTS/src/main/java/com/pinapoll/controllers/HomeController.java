package com.pinapoll.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchControls;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;
import com.pinapoll.models.User;
import com.pinapoll.services.PollService;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PollServiceImpl pollService;
	
	
    
    @GetMapping("/")
    public ModelAndView home() {
        
    	ModelAndView modelAndView = new ModelAndView();
        List<Poll> polls = pollService.getAll();
        modelAndView.addObject("polls", polls);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    @GetMapping("/search_user")
    public ModelAndView searchUser(@RequestParam String name)
    {
    	if (name == "")
    	{
    		// TODO message erreur
    	}
    	ModelAndView modelAndView = new ModelAndView();
    	List<User> users = userService.searchUserWithName(name);
    	modelAndView.addObject("users", users);
        modelAndView.setViewName("index");
    	return modelAndView;
    }
    
    @GetMapping("/search_poll")
    public ModelAndView searchPoll(@RequestParam(defaultValue = "") String question, @RequestParam(defaultValue = "") String categoryName)
    {
    	if (question == "" && categoryName == "")
    	{
    		// TODO message erreur
    	}
    	ModelAndView modelAndView = new ModelAndView();
    	List<Poll> polls = pollService.complexPollsSearch(question, categoryName);
    	modelAndView.addObject("polls", polls);
        modelAndView.setViewName("index");
    	return modelAndView;
    }
    
    @GetMapping("/add")
    public String add(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	
    	User n = new User();
		n.setName(name);
		n.setEmail("mail");
		model.addAttribute("name", n.getName());
		userService.saveUser(n);
        return "greeting";
    }
    
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userService.findAll();
	}
	
	@GetMapping("/show")
	public @ResponseBody User getUser(@RequestParam(name="name", required=true) String name) {
		// This returns a JSON or XML with the users
		return userService.findUserByName(name);
	}

}
