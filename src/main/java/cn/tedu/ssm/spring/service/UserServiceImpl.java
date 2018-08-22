package cn.tedu.ssm.spring.service;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ssm.spring.Mapping.mapping;
import cn.tedu.ssm.spring.entity.User;
import cn.tedu.ssm.spring.service.excption.DataNotFoundException;
import cn.tedu.ssm.spring.service.excption.ServiceException;
import cn.tedu.ssm.spring.service.excption.UserExction;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="mapping")
	private mapping mapping ;
	
	@Transactional
	public int regist(User use) {
		//检查用户名是否已被占用
		String username =use.getUsername();
		User u =findByUsername(username);
		if(u==null){
			mapping.regist(use);
			return use.getId();
		}else{
			throw new DataNotFoundException("该用户已注册"+username);
		}
		
	}	

	public User findByUsername(String username) {
		
			return mapping.findByUsername(username);
			
	}
	public User Login(String username,String password){
		User use =mapping.findByUsername(username);
		if(use!=null){
			if(password.equals(use.getPassword())){
				//验证成功登陆
				return use;
			};
			
		}
		throw new ServiceException("用户名不存在");
	}

}
