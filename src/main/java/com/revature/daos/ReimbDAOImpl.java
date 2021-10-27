package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.utils.HibernateUtil;
import com.revature.models.Reimb;

public class ReimbDAOImpl implements ReimbDAO {

	public List<Reimb> findAll(){
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM Reimb").list();
	}
	
	public Reimb findById(int reimbId) {
		Session session = HibernateUtil.getSession();
		return session.get(Reimb.class,reimbId);
	}
	
	public boolean addReimb(Reimb reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reimb);
			tx.commit();
			HibernateUtil.closeSession();		
			return true;
		} catch(HibernateException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateReimb(Reimb reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(reimb);
			tx.commit();
			HibernateUtil.closeSession();		
			return true;
		} catch(HibernateException e ) {
			e.printStackTrace();
			return false;
		}
	}
}
