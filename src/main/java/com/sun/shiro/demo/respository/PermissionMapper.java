package com.sun.shiro.demo.respository;

import java.util.Set;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PermissionMapper {

	@Results({
			@Result(column="permission",property="permission")
	})
	@Select("select permission from basic_permission "
			+ "where id in (select permission_id from role_permission where role_id in "
			+ "(select role_id from user_role where user_id = ("
			+ "select id from basic_user where account = #{account}"
			+ ")))")
	Set<String> getPermissionsByAccount(String account);
}
