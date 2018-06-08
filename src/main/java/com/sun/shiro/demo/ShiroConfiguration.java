package com.sun.shiro.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	@Bean
	public SecurityManager securityManager() {
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realm());
		
		return securityManager;
	}
	
	@Bean
	public Realm realm() {
		
		ShiroTempUtil realm = new ShiroTempUtil();
		realm.setCredentialsMatcher(credentialsMatcher());
		return realm;
	}
	
	@Bean
	public ShiroFilterFactoryBean factoryBean() {
		
		ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
		
		factory.setSecurityManager(securityManager());
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/loginCheck", "anon");
		filterChainDefinitionMap.put("/logout", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/*", "authc");
		factory.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		factory.setLoginUrl("/login");
		factory.setSuccessUrl("/getCurrentUser");
		return factory;
	}
	
	@Bean
	public HashedCredentialsMatcher credentialsMatcher() {
		
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(1);
		
		return matcher;
	}
}
