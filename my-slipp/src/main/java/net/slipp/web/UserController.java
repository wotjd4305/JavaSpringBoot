package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages= {"net.slipp.web"})
public class UserController {
	private List<User> users = new ArrayList<User>();
	
	//연결해주기
	@RequestMapping("/")
	public String create(User user) {
		System.out.println("user : " + user);
		users.add(user);
		return "redirect:/list";
	}
	
	//연결해주기
	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("user", users); 
		return "list";
	}

}
