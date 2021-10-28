package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.services.ReimbService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller{
	
	private ReimbService reimbService = new ReimbService();
	
	public Handler findAllReimb = (ctx) -> {
		System.out.println("in findAllHandler");
		if(ctx.req.getSession(true)!=null) {
			List<Reimb> reimbs = reimbService.findAll();
			System.out.println(reimbs);
			ctx.json(reimbs);
			ctx.status(200);
			}else {
				ctx.status(417);
			}
	};
	
	/*public Handler findById = (ctx) -> {
		if(ctx.req.getSession(false)!=null) {
		try {
			String idString = ctx.pathParam("ers_reimbursement");
			int reimbId = Integer.parseInt(idString);
			Reimb reimb = reimbService.findById(reimbId);
			ctx.json(reimb);
			ctx.status(200);
		}catch (Exception e) {
			e.printStackTrace();
			ctx.status(406);
		}}else {
			ctx.status(401);
		}
	};
	*/
	public Handler addReimb = (ctx) ->{
		if(ctx.req.getSession(true)!=null) {
		ReimbDTO reimbDTO = ctx.bodyAsClass(ReimbDTO.class);
		Reimb reimb = reimbDTO.toUser();
		//Reimb reimb = ctx.bodyAsClass(Reimb.class);
		System.out.println(reimb.toString());
		if(reimbService.addReimb(reimb)) {
			ctx.status(201);
		}else {
			ctx.status(500);
		}}else {
			ctx.status(404);
		}
	};
	/*
	public Handler updateReimb = (ctx)->{
		if(ctx.req.getSession(false)!=null) {
		Reimb reimb = ctx.bodyAsClass(Reimb.class);
		if(reimbService.updateReimb(reimb)) {
			ctx.status(202);
		}else {
			ctx.status(400);
		}}
	};*/
	
	public void addRoutes(Javalin app) {
		app.get("/reimbs", this.findAllReimb);
		//app.get("/reimbs/:ers_reimbursement", this.findById);
		app.post("/reimbs", this.addReimb);
		//app.put("/reimbs", this.updateReimb);

	}
}
