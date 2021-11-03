package com.revature;

import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.utils.HibernateUtil;
import com.revature.controllers.Controller;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	private static Javalin app;

	public static void main(String[] args) {	
		/*User user = new User();
		UserService us = new UserService();
		us.findById(0);*/
		
		//HibernateUtil hu = new HibernateUtil();
		//hu.getSession();
		
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		configure(new ReimbController(), new UserController());
		app.start(8081);
	}	
	private static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}
}