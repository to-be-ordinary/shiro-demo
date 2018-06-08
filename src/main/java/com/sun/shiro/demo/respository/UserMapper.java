package com.sun.shiro.demo.respository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sun.shiro.demo.data.BasicUser;

public interface UserMapper {

	@Insert("insert into basic_user (id,account,username,password) values (#{id},#{account},#{username},#{password})")
	@SelectKey(before=true,keyProperty="id",resultType=int.class, statement = { "just test" })
	int insert(BasicUser user);
	
	@Select("select * from basic_user where account = #{account}")
	BasicUser selectUserByAccount(String account);
}
