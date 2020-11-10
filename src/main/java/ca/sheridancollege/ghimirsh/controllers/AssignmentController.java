package ca.sheridancollege.ghimirsh.controllers;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;

//import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.ghimirsh.beans.CSRFormat;
import ca.sheridancollege.ghimirsh.service.CSRFService;

@Controller
public class AssignmentController {

	@GetMapping("/assignment1")
	public String goAssignment1(Model model) {
		model.addAttribute("objCSRFormat", new CSRFormat());
		return "assignment1";
	}

	@GetMapping("/add")
	public String doAddCSRFormat(Model model, @ModelAttribute CSRFormat objCSRFormat) {
		//for testing purpose on console
		//System.out.println(objCSRFormat.toString());
		CSRFService objCSRFService = new CSRFService();
		CSRFormat temp ;
		//File file;
		try {
			temp = objCSRFService.testCSRFService(objCSRFormat);
			String seperator = ", ";
			model.addAttribute("objCSRFormat", temp);
			model.addAttribute("seperator",seperator);
			System.out.println("Printed from Controller");
			temp.printMatrix();
			//calculateVJI(temp);
			System.out.println(objCSRFormat.toString());
			return "output";
		}
		catch(Exception e) {
			return e.getMessage();
		}
				
	}

	@GetMapping("/output")
	public String goOutput() {

		return "output";
	}

}
