package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.models.LoginReq;
import com.revature.models.LoginRes;
import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller {
	private static Logger log = LoggerFactory.getLogger(ReimbController.class);
	private UserService userService = new UserService();
	
	private Handler login = (ctx) -> {
		LoginReq loginReq = ctx.bodyAsClass(LoginReq.class);
		loginReq.hashPass();
		LoginRes loginRes = userService.login(loginReq);	
		if(loginRes!=null) {
			ctx.json(loginRes);
			ctx.status(200);
		}else {
			ctx.req.getSession().invalidate();
			ctx.status(406);
			log.warn("Login failed. Invalidating Session");
		}
	};
	
	public Handler findById = (ctx) -> {
		if (ctx.req.getSession(true) != null) {
			try {
				String idString = ctx.pathParam("userId");
				int id = Integer.parseInt(idString);
				User user = userService.findById(id);
				ctx.json(user);
				ctx.status(200);
				log.debug("UserController findById success");
			} catch (Exception e) {
				log.warn(e.getStackTrace().toString());
				ctx.status(500);
			}
		} else {
			log.warn("UserController findById failure");
			ctx.status(401);
		}
	};
	
	@Override
	public void addRoutes(Javalin app) {
		app.get("/user/:userId", this.findById);
		app.post("/user/login", this.login);
	}

}
