package ca.sheridancollege.ghimirsh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.ghimirsh.beans.PartASquareMatrix;
import ca.sheridancollege.ghimirsh.service.PartASquareMatrixService;

@Controller
public class MidTermController {
	
	@GetMapping("/midTermPartA")
	public String goMidTermPartA(Model model) {
		model.addAttribute("partASquareMatrix", new PartASquareMatrix());
		return "midTermPartA";
	}
	@GetMapping("/midTermPartB")
	public String goMidTermPartB() {
		return "midTermPartB";
	}
	
	@GetMapping("/outputMidTermPartA")
	public String goOutputMidTermPartA(Model model, @ModelAttribute PartASquareMatrix partASquareMatrix ) {
		PartASquareMatrixService partASquareMatrixService = new PartASquareMatrixService();
		PartASquareMatrix temp = partASquareMatrixService.testPartASquareMatrixService(partASquareMatrix);
		
		model.addAttribute("partASquareMatrix", temp);
		
		return "outputMidTermPartA";
	}
	
	@GetMapping("/fillMatrix")
	public String fillMatrix(Model model) {
		System.out.println("Testing from fillMatrix() mapping method: ");
		model.addAttribute("partASquareMatrix", new PartASquareMatrix());
		return "outputMidTermPartA";
	}

}
