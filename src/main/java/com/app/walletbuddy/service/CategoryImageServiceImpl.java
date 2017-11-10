package com.app.walletbuddy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.walletbuddy.dao.CategoryImageDAO;
import com.app.walletbuddy.model.CategoryImage;

@Service
public class CategoryImageServiceImpl implements CategoryImageService {

	private CategoryImageDAO categoryImageDAO;
	
	public void setCategoryImageDAO(CategoryImageDAO categoryImageDAO) {
		this.categoryImageDAO = categoryImageDAO;
	}

	
	@Override
	@Transactional
	public String getCategoryImage(int id) {
		return this.categoryImageDAO.getCategoryImage(id);
	}

	@Override
	@Transactional
	public List<CategoryImage> getCategoryImages() {
		return this.categoryImageDAO.getCategoryImages();
	}

}
