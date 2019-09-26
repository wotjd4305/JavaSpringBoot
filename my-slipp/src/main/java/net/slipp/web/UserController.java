package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@ComponentScan(basePackages = "net.slipp.web")
@EntityScan(basePackages = "net.slipp.web")
public class UserController {
	private List<User> users = new ArrayList<User>();
	
	//연결해주기
	@RequestMapping(value="/create" , method = {RequestMethod.GET, RequestMethod.POST})
	public String create(User user) {
		System.out.println("user : " + user);
		users.add(user);
		return "redirect:/list";
	}
	
	//연결해주기
	@RequestMapping(value="/list" , method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		model.addAttribute("user", users); 
		return "list";
	}

}
