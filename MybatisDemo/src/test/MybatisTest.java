package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import entity.User;

public class MybatisTest {

	SqlSessionFactory factory;

	@Before
	public void init() {
		String res = "config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(res);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@Test
	public void findById() {
		SqlSession session=null;
		try {
			//sqlSession代表数据库会话==connection
			//openSession关闭自动提交
			session=factory.openSession();
			//把映射文件的sql语句和参数都传递进来
			User user=session.selectOne("findById",1);
			System.out.println(user);
		} finally {
			session.close();
		}
				
	}
	@Test
	public void findByName() {
		SqlSession session=null;
		try {
			//sqlSession代表数据库会话==connection
			//openSession关闭自动提交
			session=factory.openSession();
			//把映射文件的sql语句和参数都传递进来
			List<User> users=session.selectList("findByName",'s');
			System.out.println(users);
		} finally {
			session.close();
		}
				
		
	}
}
