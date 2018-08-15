package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hamcrest.Factory;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
    //依赖注入
	SqlSessionFactory factory;
    
	//构造方法注入
    public UserDaoImpl(SqlSessionFactory factory) {
		this.factory=factory;
	}
	@Override
	public void saveUser(User user) {
		
		
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findById(int id) {
		SqlSession session = factory.openSession();
		String stmt="entity.User"+".findById";
		User user = session.selectOne(stmt, id);
		System.out.println(user);
		session.close();// 把connection对象还给连接池
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
