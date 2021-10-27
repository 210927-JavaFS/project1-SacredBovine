package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM User").list();
	}

	@Override
	public User findById(int userId) {
		Session session = HibernateUtil.getSession();
		return session.get(User.class,userId);
	}

	@Override
	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			HibernateUtil.closeSession();		
			return true;
		} catch(HibernateException e ) {
			e.printStackTrace();
			return false;
		}
	}

}
