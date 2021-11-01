package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.LoginReq;
import com.revature.models.LoginRes;
import com.revature.models.User;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	public LoginRes login(LoginReq loginReq) {
		LoginRes loginRes = null; 
		List<User> users= userDAO.findAll();
		for(User user:users) {
			if(user.getErsUserName().equals(loginReq.getUsername())) {
				if(user.getErsPassword().equals(loginReq.getPassword()))
				{
					System.out.println(user);
					loginRes = new LoginRes(user.getErsUserId(), 
							user.getUserFirstName()+" "+user.getUserLastName(),
							user.getUserRole().getRoleId());
				}
			}
		}
		return loginRes;
	}
	public User findById(int userId) {
		return userDAO.findById(userId);
	}
}
