package com.baylogic.peoplecentral.service;

import java.sql.SQLException;

/**
 * 
 * @author Naresh
 *
 */

public interface UserService {
	public boolean isValidUser(String Username, String Password)throws SQLException;
}
