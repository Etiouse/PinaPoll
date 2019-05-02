package com.pinapoll.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pinapoll.models.Poll;
import com.pinapoll.models.User;
import com.pinapoll.services.PollServiceImpl;
import com.pinapoll.services.UserService;

@Controller
public class HomeController {
	
	private final String INDEX = "index";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PollServiceImpl pollService;
	    
    @GetMapping("/")
    public ModelAndView home() {
    	return getPage(1);
    }
    
    @GetMapping("/{page}")
    public ModelAndView homeWithPage(@PathVariable("page") int page) {
    	return getPage(page);
    }
    
    private ModelAndView getPage(int page){
    	ModelAndView modelAndView = new ModelAndView();
        Page<Poll> polls = pollService.getAll(PageRequest.of(page-1, 3));

       	int totalPages = polls.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("page_numbers", pageNumbers);
        }
                
        modelAndView.addObject("polls", polls);
        modelAndView.setViewName(INDEX);
        return modelAndView;
    }
    
    @GetMapping("/search_user")
    public ModelAndView searchUser(@RequestParam String name)
    {
    	if (name.equals(""))
    	{
    		
    	}
    	ModelAndView modelAndView = new ModelAndView();
    	List<User> users = userService.searchUserWithName(name);
    	modelAndView.addObject("users", users);
        modelAndView.setViewName(INDEX);
    	return modelAndView;
    }
    
    @GetMapping("/search_poll")
    public ModelAndView searchPoll(@RequestParam(defaultValue = "") String question, @RequestParam(defaultValue = "") String categoryName)
    {
    	if (question.equals("") && categoryName.equals(""))
    	{
    		
    	}
    	ModelAndView modelAndView = new ModelAndView();
    	List<Poll> polls = pollService.complexPollsSearch(question, categoryName);
    	modelAndView.addObject("polls", polls);
        modelAndView.setViewName(INDEX);
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
