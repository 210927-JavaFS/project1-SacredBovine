package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.daos.ReimbDAO;
import com.revature.daos.ReimbDAOImpl;
import com.revature.models.Reimb;

public class ReimbService {

	private static Logger log = LoggerFactory.getLogger(ReimbService.class);
	private ReimbDAO reimbDAO = new ReimbDAOImpl();
	
	public List<Reimb> findAll(){
		return reimbDAO.findAll();
	}	
	public Reimb findById(int id){
		Reimb reimb  = reimbDAO.findById(id);
		if(reimb!=null) {
			return reimb;
		}else {
			return new Reimb();
		}
	}	
	public List<Reimb> findByUser(int userId) {
		List<Reimb> reimbs = reimbDAO.findAll();
		List<Reimb> userReimbs = new ArrayList<Reimb>();
		if(reimbs!=null) {
			for(int i=0; i<reimbs.size(); i++) {
				if(reimbs.get(i).getReimbAuthor().getErsUserID()==userId) {
					userReimbs.add(reimbs.get(i));
				}
			}
			return userReimbs;
		}else {
			return null;
		}
	}
	public List<Reimb> findByOpen() {
		List<Reimb> reimbs = reimbDAO.findAll();
		List<Reimb> openReimbs = new ArrayList<Reimb>();
		if(reimbs!=null) {
			for(int i=0; i<reimbs.size(); i++) {
				if(reimbs.get(i).getReimbStatus().getStatus().equals("pending")) {
					openReimbs.add(reimbs.get(i));
				}
			}
			return openReimbs;
		}else {
			return null;
		}
	}
	
	public boolean addReimb(Reimb reimb) {
		return reimbDAO.addReimb(reimb);
	}
	
	public boolean updateReimb(Reimb reimb) {
		return reimbDAO.updateReimb(reimb);
	}	
}