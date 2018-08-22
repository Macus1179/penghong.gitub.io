package cn.tedu.ssm.spring.Mapping;



import cn.tedu.ssm.spring.entity.User;

public interface mapping {

	Integer regist(User user);
	
	User findByUsername(String username);
	
	
	
}
