package com.revature;

import com.revature.controllers.ReimbController;
import com.revature.daos.ReimbDAO;
import com.revature.daos.ReimbDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.controllers.Controller;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	
	private static Javalin app;

	
	public static void main(String[] args) {
		ReimbDAO reimbDAO = new ReimbDAOImpl();
		UserDAO userDao = new UserDAOImpl();
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		
		configure(new ReimbController());
	/*	ReimbStatus status = new ReimbStatus(1,"pending");
		ReimbType type = new ReimbType(3,"food");
		
		UserRole role = new UserRole(1,"employee");
		User user = new User("employee","password","Mike","Tython","KnockYou@out.com",role);
		userDao.addUser(user);
		Reimb reimb = new Reimb(50,"hungry",user,status,type);*/
		//reimbDAO.addReimb(reimb);
		
		
		
		
		app.start(8081);

	}
	
	private static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}

}
