package com.revature.controllers;

import java.util.List;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.services.ReimbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller{
	
	private static Logger log = LoggerFactory.getLogger(ReimbController.class);
	private ReimbService reimbService = new ReimbService();
	
	public Handler findAllReimb = (ctx) -> {
		if(ctx.req.getSession(true)!=null) {
			List<Reimb> reimbs = reimbService.findAll();
			ctx.json(reimbs);
			ctx.status(200);
			log.debug("ReimbController findAllReimb success");
		}else {
			ctx.status(417);
		}
	};	
	public Handler findById = (ctx) -> {
		if (ctx.req.getSession(true) != null) {
			try {
				String idString = ctx.pathParam("reimbId");
				int id = Integer.parseInt(idString);
				Reimb reimb = reimbService.findById(id);
				ctx.json(reimb);
				ctx.status(200);
				log.debug("ReimbController findById success");
			} catch (Exception e) {
				log.warn(e.getStackTrace().toString());
				ctx.status(500);
			}
		} else {
			ctx.status(401);
		}
	};
	public Handler findByUser = (ctx) -> {
		if(ctx.req.getSession(true)!=null) {
		try {
			String idString = ctx.pathParam("userId");
			int id = Integer.parseInt(idString);
			List<Reimb> Reimbs = reimbService.findByUser(id);
			ctx.json(Reimbs);
			ctx.status(200);
			log.debug("ReimbController findByUser success");
		}catch (Exception e) {
			log.warn(e.getStackTrace().toString());
			ctx.status(500);
		}}else {
			ctx.status(417);
		}
	};
	public Handler findByOpen = (ctx) -> {
		if(ctx.req.getSession(true)!=null) {
		try {
			List<Reimb> openReimbs = reimbService.findByOpen();
			ctx.json(openReimbs);
			ctx.status(200);
			log.debug("ReimbController findByOpen success");
		}catch (Exception e) {
			log.warn(e.getStackTrace().toString());
			ctx.status(500);
		}}else {
			ctx.status(417);
		}
	};

	public Handler addReimb = (ctx) ->{
		if(ctx.req.getSession(true)!=null) {
		ReimbDTO reimbDTO = ctx.bodyAsClass(ReimbDTO.class);
		Reimb reimb = reimbService.toReimb(reimbDTO);
		System.out.println(reimb.toString());
		if(reimbService.addReimb(reimb)) {
			ctx.status(201);
			log.debug("ReimbController addReimb success");
		}else {
			ctx.status(500);
		}}else {
			ctx.status(404);
		}
	};
	
	public Handler updateReimb = (ctx)->{
		if(ctx.req.getSession(true)!=null) {
		Reimb reimb = ctx.bodyAsClass(Reimb.class);
		if(reimbService.updateReimb(reimb)) {
			ctx.status(202);
			log.debug("ReimbController updateReimb success");
		}else {
			ctx.status(400);
		}}
	};
	
	public void addRoutes(Javalin app) {
		app.get("/reimbs", this.findAllReimb);
		app.get("/reimbs/open", this.findByOpen);
		app.get("/reimbs/:reimbId", this.findById);
		app.post("/reimbs", this.addReimb);
		app.put("/reimbs", this.updateReimb);
		app.get("/reimbs/user/:userId", this.findByUser);

	}
}