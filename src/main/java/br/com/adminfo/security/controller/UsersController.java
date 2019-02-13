package br.com.adminfo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.adminfo.security.models.User;
import br.com.adminfo.security.services.AutoLogin;
import br.com.adminfo.security.services.UserService;
import br.com.adminfo.security.validator.UserValidate;

@Controller
public class UsersController {
	
	@Autowired
	private UserValidate userValidate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AutoLogin autoLogin;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		userValidate.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		userService.save(user);
		autoLogin.autoLogin(user.getUsername(), user.getPassword());
		
		return "redirect:/hello";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value={"/", "/hello"})
	public String hello(Model model) {
		return "hello";
	}

}