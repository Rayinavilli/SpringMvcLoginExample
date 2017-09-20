package com.baylogic.peoplecentral.dao.impl;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.baylogic.peoplecentral.dao.UserDao;

/**
 * 
 * @author Naresh
 *
 */

public class UserDaoImpl implements UserDao{
  DataSource dataSource;
  
  public DataSource getDataSource(){
	  return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource){
	  this.dataSource = dataSource;
  }
  
  @Override
  public boolean isValidUser(String username, String password) throws SQLException{
	  String query = "select count(1) from users where username=? and password=?";
	  PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
	  pstmt.setString(1, username);
	  pstmt.setString(2, password);
	  ResultSet resultSet = pstmt.executeQuery();
	  if(resultSet.next())
		  return (resultSet.getInt(1)>0);
	  else 
		  return false;
  }
}
