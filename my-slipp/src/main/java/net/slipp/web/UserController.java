package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private List<User> users = new ArrayList<User>();
	
	//연결해주기
	@PostMapping("/create")
	public String create(User user) {
		System.out.println("user : " + user);
		users.add(user);
		return "redirect:/list";
	}
	
	//연결해주기
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("user", users); 
		return "list";
	}

}
