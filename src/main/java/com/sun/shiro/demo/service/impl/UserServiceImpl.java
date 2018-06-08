package com.sun.shiro.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.shiro.demo.data.BasicUser;
import com.sun.shiro.demo.respository.UserMapper;
import com.sun.shiro.demo.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper uerMapper;
	@Override
	public BasicUser getUserByAccount(String account) {
		return uerMapper.selectUserByAccount(account);
	}

}
