package com.app.walletbuddy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.springframework.stereotype.Repository;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
	}

	@Override
	public void updateUserWallet(float amount) {
		Session session = this.sessionFactory.getCurrentSession();
//		session.update(u);
	}

	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession(); 
		List<User> usersList = session.createQuery("from User").list();
		return usersList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		List<User> usersList = session.createQuery("from User U WHERE U.id='"+id+"'").list();
		if(usersList.size()>0)
			   return usersList.get(0);
			else return null;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = new User();
		u.setId(id);
		session.delete(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByCredentials(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User U WHERE U.email='"+email+"' AND U.password='"+password+"'").list();
		 
		if(usersList.size()>0)
		   return usersList.get(0);
		else return null;
	}

}
