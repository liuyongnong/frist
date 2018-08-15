package test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import dao.UserDao;
import entity.User;

public class MyBatisProxy {

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
		SqlSession session = null;
		try {
			// sqlSession代表数据库会话==connection
			// openSession关闭自动提交
			session = factory.openSession();
			UserDao dao=session.getMapper(UserDao.class);
		    User user=dao.findById(1);
			System.out.println(user);
		} finally {
			session.close();
		}

	}

}
