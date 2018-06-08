package com.sun.shiro.demo.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.shiro.demo.respository.PermissionMapper;
import com.sun.shiro.demo.service.IPermissionService;
@Service
@Transactional
public class PemissionServiceImpl implements IPermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public Set<String> getPermissionStrByAccount(String account) {
		return permissionMapper.getPermissionsByAccount(account);
	}

	
}
