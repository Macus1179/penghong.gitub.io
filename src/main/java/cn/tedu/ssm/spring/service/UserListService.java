package cn.tedu.ssm.spring.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ssm.spring.entity.userList;

public interface UserListService {
	List<userList> findAll();
	 
	 int add(userList u);
}
