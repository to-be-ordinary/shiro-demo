package com.sun.shiro.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.shiro.demo.data.BasicRole;
import com.sun.shiro.demo.respository.RoleMapper;
import com.sun.shiro.demo.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<BasicRole> getRolesByAccount(String account) {
		return roleMapper.selectRolesByAccount(account);
	}

}
