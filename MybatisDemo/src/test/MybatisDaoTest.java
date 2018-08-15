package test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.impl.UserDaoImpl;
import entity.User;


public class MybatisDaoTest {

	SqlSessionFactory factory;
	UserDaoImpl impl;
	User user;

	@Before
	public void setUp() throws Exception {
		String res = "config.xml";
		InputStream in = Resources.getResourceAsStream(res);
		factory = new SqlSessionFactoryBuilder().build(in);
		impl = new UserDaoImpl(factory);
		user = new User();

	}
	
	
	@Test
	public void findById() {
		User user=impl.findById(1);
		System.out.println(user);
	}
}
