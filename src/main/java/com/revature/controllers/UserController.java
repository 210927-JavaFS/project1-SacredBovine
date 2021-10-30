package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.models.LoginReq;
import com.revature.models.LoginRes;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller {
	private static Logger log = LoggerFactory.getLogger(ReimbController.class);
	private UserService userService = new UserService();
	
	private Handler login = (ctx) -> {
		System.out.println("Login attempt!");
		LoginReq loginReq = ctx.bodyAsClass(LoginReq.class);
		loginReq.hashPass();
		LoginRes loginRes = userService.login(loginReq);	
		System.out.println(loginRes);
		if(loginRes!=null) {
			ctx.json(loginRes);
			ctx.status(200);
		}else {
			ctx.req.getSession().invalidate();
			ctx.status(406);
			log.warn("Login failed. Invalidating Session");
		}
	};
	
	@Override
	public void addRoutes(Javalin app) {
		app.post("/login", this.login);
	}

}
