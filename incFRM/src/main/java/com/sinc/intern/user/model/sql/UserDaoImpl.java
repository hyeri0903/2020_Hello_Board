package com.sinc.intern.user.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("userD")
public class UserDaoImpl implements UserDao{
	
	@Resource(name = "sqlSession")
	private SqlSession session ;
	
	public static final String PREFIX = "com.sinc.intern.test";
	

	@Override
	public Object loginRow(Object obj) {
		System.out.println("user dao loginRow: " + obj);
		System.out.println("user dao conn: " + session);
		
		Object result = session.selectOne(PREFIX + ".login", obj) ;
		System.out.println("dao loginRow result : " + result);
		return result;
	}

}
