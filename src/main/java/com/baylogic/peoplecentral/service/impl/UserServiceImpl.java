package com.baylogic.peoplecentral.service.impl;

import java.sql.SQLException;

import com.baylogic.peoplecentral.dao.UserDao;
import com.baylogic.peoplecentral.service.UserService;

public class UserServiceImpl implements UserService{
		private UserDao userDao;
		
		public UserDao getUserDao(){
			return this.userDao;
		}
		
		public void setUserDao(UserDao userDao){
			this.userDao = userDao;
		}
		
		@Override
		public boolean isValidUser(String username, String password) throws SQLException
		{
			return userDao.isValidUser(username,password);
		}
		
		public boolean createUser(String firstname,String lastname, int id, String email) throws SQLException
		{
			return userDao.createUser(firstname,lastname,id,email);
		}
}
