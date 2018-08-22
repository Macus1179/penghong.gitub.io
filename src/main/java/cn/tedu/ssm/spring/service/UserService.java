package cn.tedu.ssm.spring.service;

import cn.tedu.ssm.spring.entity.User;

public interface UserService {
	int regist(User use);
	
	User findByUsername(String username);
	
	User  Login(String username,String password);
}
