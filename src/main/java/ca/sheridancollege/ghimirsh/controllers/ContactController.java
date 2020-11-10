package ca.sheridancollege.ghimirsh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.ghimirsh.beans.User;

@Controller
public class ContactController {
	
	@GetMapping("/contact")
	public String goContact(Model model) {
		model.addAttribute("user", new User());
		return "contact";
	}
	
	@PostMapping("/processContact")
	public String processContact(Model model, @ModelAttribute User user) {
		System.out.println("Testing the ProcessContact Mapping...");
		model.addAttribute("user", user);
		return "contact";
	}
	
	

}
