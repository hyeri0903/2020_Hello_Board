package com.sinc.intern.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.intern.user.model.sql.UserDao;

@Service("userS")

public class UserServiceImpl implements UserService {
	
	@Resource(name = "userD")
	private UserDao dao ;
	

	@Override
	public Object login(Object obj) {
		System.out.println("user service login: " + obj );
		return dao.loginRow(obj);
	}

}
