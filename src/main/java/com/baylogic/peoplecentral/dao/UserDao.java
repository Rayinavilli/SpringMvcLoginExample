package com.baylogic.peoplecentral.dao;

import java.sql.SQLException;

/**
 * 
 * @author Naresh
 *
 */

public interface UserDao {
	
	public boolean isValidUser(String username,String password) throws SQLException;
	
	public boolean createUser(String firstname,String lastname, int id, String email) throws SQLException;
}
