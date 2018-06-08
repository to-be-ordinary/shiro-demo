package com.sun.shiro.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/getCurrentUser")
	public String getUserName() {
		
		return "currentUserName";
	}
}
