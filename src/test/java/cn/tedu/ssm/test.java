package cn.tedu.ssm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.xdevapi.SessionFactory;

import cn.tedu.ssm.spring.Mapping.DynamicDataSource;
import cn.tedu.ssm.spring.Mapping.DynamicDataSourceHolder;
import cn.tedu.ssm.spring.entity.User;
import cn.tedu.ssm.spring.entity.userList;
import cn.tedu.ssm.spring.service.UserListService;
import cn.tedu.ssm.spring.service.UserService;
import cn.tedu.ssm.spring.service.UserServiceImpl;

public class test {
	@Test
	public void test() throws SQLException{
		MapperScannerConfigurer msc;
		SqlSessionFactoryBean ssfb;
		AbstractApplicationContext ac=new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-mvc.xml","spring-service.xml");
		DynamicDataSource dataSource=ac.getBean("dataSource",DynamicDataSource.class);
		
		Connection conn=dataSource.getConnection();
		
		UserService ue =ac.getBean("userService",UserService.class);
		User u =ue.findByUsername("123");
		
		System.out.println(u.toString());
		ac.close();
	}

	@Test
	public void test2() throws SQLException{
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext("spring-dao.xml","spring-mvc.xml","spring-service.xml");
		DynamicDataSourceHolder.setDataSource("jdbc_dataSource");
		DynamicDataSource dataSource=ac.getBean("dataSource",DynamicDataSource.class);
		
		UserListService u =ac.getBean("userListService",UserListService.class);
		u.findAll();
		System.out.println(u);
		ac.close();
	}
}
