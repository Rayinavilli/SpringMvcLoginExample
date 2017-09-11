package com.baylogic.peoplecentral.dao;

import java.sql.SQLException;

/**
 * 
 * @author Naresh
 * This Interface will be used to communicate 
 * with DataBase
 */

public interface UserDao {
	public boolean isValidUser(String username, String password) throws SQLException;
}
