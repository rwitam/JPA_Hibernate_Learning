package org.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "hellowworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersionTwo")
	public String convertToCaps(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Hey " + theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Hey From V3" + theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
}
