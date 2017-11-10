package com.app.walletbuddy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.User;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	
	@Override
	public void addCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
	}
	
	@Override
	public void updateCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	}

	@Override
	public List<Category> listCategory(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category C WHERE C.userId='"+userId+"' ORDER BY C.id DESC").list();
		session.clear(); 
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Category> catList = session.createQuery("from Category C WHERE C.id='"+id+"'").list();
		if(catList.size()>0)
			   return catList.get(0);
			else return null;
	}

	@Override
	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = new Category();
		c.setId(id);
		session.delete(c); 
//		session.createQuery("delete Category C where C.id='"+id+"'").executeUpdate();
	}

}
