package com.sun.shiro.demo.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	public static Logger log = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(String username,String pwd) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
		try {
			
			subject.login(token);
		}catch(UnknownAccountException e) {
			
			log.error("用户名不存在" + e.getMessage());
			return "redirect:/login";
		}catch (IncorrectCredentialsException e) {
			
			log.error("密码错误：" + e.getMessage());
			return "redirect:/login";
		}catch (Exception e) {
			
			log.error("服务器异常：" + e.getMessage());
			return "redirect:/login";
		}
		
		
		return "redirect:/getCurrentUser";
	}
}
