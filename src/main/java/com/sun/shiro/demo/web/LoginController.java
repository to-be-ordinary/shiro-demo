package com.sun.shiro.demo.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(String username,String pwd) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
		try {
			
			subject.login(token);
		}catch(UnknownAccountException e) {
			
			return "用户名不存在" + e.getMessage();
		}catch (IncorrectCredentialsException e) {
			
			return "密码错误：" + e.getMessage();
		}catch (Exception e) {
			
			return "服务器异常：" + e.getMessage();
		}
		
		
		return "";
	}
}
