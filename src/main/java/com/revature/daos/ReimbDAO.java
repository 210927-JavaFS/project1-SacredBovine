package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;

public interface ReimbDAO {

	public List<Reimb> findAll();
	public Reimb findById(int id);
	public boolean addReimb(Reimb reimb);
	public boolean updateReimb(Reimb reimb);
	
	
}
