package com.sun.shiro.demo.service;

import java.util.Set;

public interface IPermissionService {

	Set<String> getPermissionStrByAccount(String account);
}
