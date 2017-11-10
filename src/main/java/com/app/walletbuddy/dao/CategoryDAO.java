package com.app.walletbuddy.dao;

import java.util.List;

import com.app.walletbuddy.model.Category;


public interface CategoryDAO {
	
	public void addCategory(Category c);
	public void updateCategory(Category c);
	public List<Category> listCategory(int userId);
	public Category getCategoryById(int id);
	public void removeCategory(int id);
	
}
