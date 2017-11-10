package com.app.walletbuddy.dao;

import java.util.List;

import com.app.walletbuddy.model.CategoryImage;

public interface CategoryImageDAO {
	public String getCategoryImage(int id);
	public List<CategoryImage> getCategoryImages();
}
