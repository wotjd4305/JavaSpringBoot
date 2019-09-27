package net.slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/helloworld")
	public String welcome(String name, int age, String company, Model model) {
		System.out.println("name : " + name +"age : " + age);
		model.addAttribute("name", name);
		model.addAttribute("company", "<b>GitHub</b>");

		
		return "welcome";
	}
}
