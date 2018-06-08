package com.sun.shiro.demo.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.shiro.demo.data.BasicUser;

@RestController
public class UserController {

	@RequiresRoles("admin")
	@RequestMapping("/getCurrentUser")
	public String getUserName() {
		
		return "currentUserName";
	}
	
	@RequiresPermissions("user:select:current")
	@RequestMapping("/username")
	public String getCurrentUser() {
		
		Subject subject = SecurityUtils.getSubject();
		BasicUser user = (BasicUser)subject.getPrincipal();
		return user.getUsername();
	}
}
