package com.revature;

import com.revature.controllers.ReimbController;
<<<<<<< HEAD
=======
import com.revature.controllers.UserController;
>>>>>>> 15b21f91cf350e808bf65bee87766e356963da0c
import com.revature.controllers.Controller;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	private static Javalin app;

<<<<<<< HEAD
	public static void main(String[] args) {
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		configure(new ReimbController());
=======
	public static void main(String[] args) {	
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		configure(new ReimbController(), new UserController());
>>>>>>> 15b21f91cf350e808bf65bee87766e356963da0c
		app.start(8081);
	}	
	private static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}
<<<<<<< HEAD

=======
>>>>>>> 15b21f91cf350e808bf65bee87766e356963da0c
}