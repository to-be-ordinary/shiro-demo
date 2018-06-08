package com.sun.shiro.demo.service;

import com.sun.shiro.demo.data.BasicUser;

public interface IUserService {

	BasicUser getUserByAccount(String account);
}
