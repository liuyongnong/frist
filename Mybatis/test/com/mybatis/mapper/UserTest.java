package com.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.mybatis.UserMybatis;
import com.mybatis.pojo.User;
import com.mybatis.util.MyBatisUtil;

public class UserTest {
	@Test
	public void testUser() {
		SqlSession session=MyBatisUtil.getSqlsession();
		UserMybatis userMybatis=session.getMapper(UserMybatis.class);
		User user =userMybatis.selectUser(3);
		session.close();
		
	}

}
