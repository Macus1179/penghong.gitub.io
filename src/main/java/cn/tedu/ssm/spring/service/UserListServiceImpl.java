package cn.tedu.ssm.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ssm.spring.Mapping.DynamicDataSourceHolder;
import cn.tedu.ssm.spring.Mapping.UserMapping;
import cn.tedu.ssm.spring.entity.userList;


@Service("userListService")
public class UserListServiceImpl implements UserListService{
@Resource(name="userMapping")
private  UserMapping mapping2;

public List<userList> findAll() {
	DynamicDataSourceHolder.setDataSource("jdbc_dataSource");
	
	return 	mapping2.findAll();
	
	
	
	}

public int add(userList u) {
	DynamicDataSourceHolder.setDataSource("jdbc_dataSource");
	return u.getId() ;
}






	
}
