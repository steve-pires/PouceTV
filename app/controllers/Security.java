package controllers;

import models.User;

public class Security extends controllers.Secure.Security {

	/**
	 * authenticates the user
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	static boolean authenticate(String username, String password) {
		return User.connect(username, password) != null;
	}

	/**
	 * Checks if the user has the profile given in parameter
	 * 
	 * @param role
	 * @return boolean
	 */
	static boolean check(String profile) {
	    if("ADMIN".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin;
	    }
	    return false;
	}
}
