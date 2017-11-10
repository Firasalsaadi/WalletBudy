package com.app.walletbuddy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.app.walletbuddy.model.CategoryImage;

@Repository
public class CategoryImageDAOImpl implements CategoryImageDAO{

    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public String getCategoryImage(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		List<String> imgList = session.createQuery("from CategoryImage CI WHERE CI.id='"+id+"'").list();
		if(imgList.size()>0)
			   return imgList.get(0);
			else return null;
	}

	@Override
	public List<CategoryImage> getCategoryImages() {
		Session session = this.sessionFactory.getCurrentSession(); 
		return  session.createQuery("from CategoryImage").list();
//		List<CategoryImage> ci = session.createQuery("from CategoryImage").list(); 
//		List<String> images = new ArrayList<String>();
//		for(CategoryImage c : ci)
//			images.add(c.getName());
//		return images;
	}

}
