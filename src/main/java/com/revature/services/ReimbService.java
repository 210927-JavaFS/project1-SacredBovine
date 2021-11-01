package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.daos.ReimbDAO;
import com.revature.daos.ReimbDAOImpl;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public class ReimbService {

	private static Logger log = LoggerFactory.getLogger(ReimbService.class);
	private ReimbDAO reimbDAO = new ReimbDAOImpl();
	private UserService userService = new UserService();
	
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
				if(reimbs.get(i).getReimbAuthor().getErsUserId()==userId) {
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
		
	public Reimb toReimb(ReimbDTO reimbDTO) {
		ReimbStatus status = new ReimbStatus();
		switch (reimbDTO.getReimbStatus()) {
			case 1 :
				status.setStatusId(1); 
				status.setStatus("pending");
				break;
			case 2 :
				status.setStatusId(2); 
				status.setStatus("approved");
				break;
			case 3 :
				status.setStatusId(3); 
				status.setStatus("denied");
				break;
		}
		
		ReimbType type = new ReimbType();
		switch (reimbDTO.getReimbType()) {
			case 1: 
				type.setTypeId(1);
				type.setType("lodging");
				break;
			case 2: 
				type.setTypeId(2);
				type.setType("travel");
				break;
			case 3: 
				type.setTypeId(3);
				type.setType("food");
				break;
			case 4: 
				type.setTypeId(4);
				type.setType("other");
				break;
		}
		User author = userService.findById(reimbDTO.getReimbAuthor());
		Reimb reimb = new Reimb( reimbDTO.getReimbAmount(), 
				reimbDTO.getReimbSubmitted(),
				reimbDTO.getReimbDescription(),
				author,
				status,
				type); 
		return reimb;
	}
	
}