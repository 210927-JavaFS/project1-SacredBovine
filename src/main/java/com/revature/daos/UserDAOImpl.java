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
	public User findById(int userId) {
		Session session = HibernateUtil.getSession();
		return session.get(User.class, userId);
	}
}