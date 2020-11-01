package ca.sheridancollege.ghimirsh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.ghimirsh.beans.PartASquareMatrix;
import ca.sheridancollege.ghimirsh.service.PartASquareMatrixService;

@Controller
public class MidTermController {
	PartASquareMatrix temp;
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
		temp = partASquareMatrixService.preparePartASquareMatrixService(partASquareMatrix);
		
		model.addAttribute("partASquareMatrix", temp);
		
		return "outputMidTermPartA";
	}
	
	
	@GetMapping("/searchMatrix")
	public String fillMatrix(Model model, @ModelAttribute PartASquareMatrix partASquareMatrix) {
		
		PartASquareMatrixService partASquareMatrixService = new PartASquareMatrixService();
		String searchValue = partASquareMatrix.getSearchValue();
		temp.setSearchValue(searchValue);
		partASquareMatrix = temp;
		temp = partASquareMatrixService.searchMatrix(partASquareMatrix);
		
		model.addAttribute("partASquareMatrix", temp);
		
		return "outputMidTermPartA";
	}

}
