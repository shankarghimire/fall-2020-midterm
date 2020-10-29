package ca.sheridancollege.ghimirsh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MidTermController {
	
	@GetMapping("/midTermPartA")
	public String goMidTermPartA() {
		return "midTermPartA";
	}
	@GetMapping("/midTermPartB")
	public String goMidTermPartB() {
		return "midTermPartB";
	}

}
