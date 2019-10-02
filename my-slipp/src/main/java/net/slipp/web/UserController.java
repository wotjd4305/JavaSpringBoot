package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {
	//private List<User> users = new ArrayList<User>();
	
	//있다고 가정하고 가져다 씀
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/loginform")
	public String loginForm() {
		return "/user/login/";
	}
	
	
	//연결해주기
		@GetMapping("/form")
		public String form() {
			return "/user/form";
		}
		
	
	//연결해주기
	@PostMapping("")
	public String create(User user) {
		System.out.println("user : " + user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	//연결해주기
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll()); 
		return "/user/list";
	}
	
	
	//연결해주기
	//PathVariable로 가져옴, 가져올 녀석이랑 이름같음 {id} = id가 되는것
	//id로 찾겠따.
			@GetMapping("{id}/form")
			public String updateForm(@PathVariable Long id, Model model) {
				User user = userRepository.findById(id).get();
				model.addAttribute("user", user);
				return "/user/updateForm";
			}
			
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, User newUser)
	{
		User user = userRepository.findById(id).get();
		user.update(newUser);
		userRepository.save(user);
		return "redirect:/users";
	}
	

}
