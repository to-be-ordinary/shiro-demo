package com.sun.shiro.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.shiro.demo.data.BasicRole;
import com.sun.shiro.demo.data.BasicUser;
import com.sun.shiro.demo.service.IPermissionService;
import com.sun.shiro.demo.service.IRoleService;
import com.sun.shiro.demo.service.IUserService;

public class ShiroTempUtil extends AuthorizingRealm{

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionService permissionService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		BasicUser user = (BasicUser)principals.getPrimaryPrincipal();
		List<BasicRole> roles = roleService.getRolesByAccount(user.getAccount());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> setRoles = new HashSet<>();
		for (BasicRole role : roles) {
			setRoles.add(role.getRoleAccount());
		}
		info.setRoles(setRoles);
		Set<String> permissions = permissionService.getPermissionStrByAccount(user.getAccount());
		
		info.addStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		String userName = (String)token.getPrincipal();
		
		BasicUser user = userService.getUserByAccount(userName);
		if(user == null)
			return null;
		else {
			
			SimplePrincipalCollection collection = new SimplePrincipalCollection();
			collection.add(token.getPrincipal(),"tempRealm" );
			info = new SimpleAuthenticationInfo(user,user.getPassword(),null,"tempRealm");
		}
			
		return info;
	}

}
