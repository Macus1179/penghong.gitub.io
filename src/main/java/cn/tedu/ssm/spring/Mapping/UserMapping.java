package cn.tedu.ssm.spring.Mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ssm.spring.entity.userList;

public interface UserMapping {

	List<userList> findAll();
	int getRowCount(@Param("username")String username);
	Integer add(userList u);
}	
