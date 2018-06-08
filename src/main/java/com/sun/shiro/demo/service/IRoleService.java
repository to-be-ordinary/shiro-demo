package com.sun.shiro.demo.service;

import java.util.List;

import com.sun.shiro.demo.data.BasicRole;

public interface IRoleService {

	List<BasicRole> getRolesByAccount(String account);
}
