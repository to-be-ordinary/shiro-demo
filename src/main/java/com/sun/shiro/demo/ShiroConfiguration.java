package com.sun.shiro.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
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
	public ShiroFilterFactoryBean factoryBean(SecurityManager securityManager) {
		
		ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
		
		factory.setSecurityManager(securityManager);
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/loginCheck", "anon");
		filterChainDefinitionMap.put("/*", "authc");
		factory.setFilterChainDefinitionMap(filterChainDefinitionMap);
		factory.setLoginUrl("/login");
		return factory;
	}
	
	@Bean
	public HashedCredentialsMatcher credentialsMatcher() {
		
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(1);
		
		return matcher;
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		
		LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
		return processor;
	}
	
	@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
	}
	
	//和授权相关
	@Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }
}
