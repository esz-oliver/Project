package com.project.controller;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.entity.User;
import com.project.service.EmailService;
import com.project.service.PostService;
import com.project.service.UserService;


@Controller
public class HomeController {
	
	 private EmailService emailService;
	 private UserService userService;
	 private PostService postService;

		@Autowired
		public void setEmailService(EmailService emailService) {
			this.emailService = emailService;
		}
		
		@Autowired
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		@Autowired
		public void setPostService(PostService postService) {
			this.postService = postService;
		}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/bloggers")
	public String bloggers() {
		return "users";
	}
	

	@RequestMapping("/posts")
	public String posts(Model model) {
		model.addAttribute("pageTitle", "Project.hu");
		model.addAttribute("posts", postService.getStories());
		return "posts";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/reg")
	public String greetingSubmit(@ModelAttribute User user) {
		emailService.sendMessage(user.getEmail(), user.getFirstName());		
		return "auth/login";
	}
	
	@RequestMapping(path = "/activation/{code}", method = RequestMethod.GET)
    public String activation(@PathVariable("code") String code, HttpServletResponse response) {
	String result = userService.userActivation(code);
	return "auth/login";
 }
	
	
}