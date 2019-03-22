package com.example.thymeleaf.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaf.data.ColorsDAO;
import com.example.thymeleaf.model.Color;

@Controller
public class AccueilController {

		@Autowired
		ColorsDAO dao;
		
		@Value("${accueil.message:test}")
		private String message;
		
		@Value("${accueil1.message:[default]}")
		private String messageParDefaut;

		@GetMapping("/")
		public String accueil(Map<String, Object> model) {
			model.put("page", "Accueil");
			return "accueil";
		}
		
		@GetMapping("/basic")
		public String basic(Map<String, Object> model) {
			model.put("message", this.message);
			model.put("page", "Concepts de bases");
			
			model.put("message", this.message);
			model.put("messageParDefaut", this.messageParDefaut);
			model.put("page", "Concepts de bases");
			
			
			model.put("couleurs", dao.getAllColors());
			return "basic";
		}
		
		@GetMapping("/form")
		public String form(Map<String, Object> model) {
			model.put("color", new Color());
			model.put("page", "Formulaire");
			return "formulaire";
		}
		
		@PostMapping("/color")
		public String saveColor(@Valid @ModelAttribute Color color, BindingResult errors, Model model) {
			
			if (!errors.hasErrors()) {
	            dao.save(color);
	        }
	        return ((errors.hasErrors()) ? "color" : "redirect:basic");
		}
}


