package com.revature.daos;

import java.util.List;
import org.hibernate.Session;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unchecked")
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