package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/home")
public class HomeController {
	//private List<User> users = new ArrayList<User>();
	
	//있다고 가정하고 가져다 씀
	@Autowired
	private UserRepository userRepository;
	
	
	//연결해주기
	@RequestMapping(value="/create" , method = {RequestMethod.GET, RequestMethod.POST})
	public String create(User user) {
		System.out.println("user : " + user);
		userRepository.save(user);
		return "redirect:/user/list";
	}
	
	

}
