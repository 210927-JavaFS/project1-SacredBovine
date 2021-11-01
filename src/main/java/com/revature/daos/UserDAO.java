package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.User;

public interface UserDAO {

	public List<User> findAll();	
	public User findById(int userId);
}
