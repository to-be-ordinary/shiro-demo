package com.sun.shiro.demo.respository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sun.shiro.demo.data.BasicRole;

public interface RoleMapper {

	@Insert("insert into basic_role (id,name,role_account) values (#{id},#{name},#{role_account})")
	public int save(BasicRole role);
	
	@Select("select * from basic_role where id in (select role_id from user_role where user_id = (select id from basic_user where account = #{account}))")
	public List<BasicRole> selectRolesByAccount(String account);
}
