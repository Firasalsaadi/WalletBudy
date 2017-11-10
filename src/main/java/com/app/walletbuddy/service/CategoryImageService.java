package com.app.walletbuddy.service;

import java.util.List;

import com.app.walletbuddy.model.CategoryImage;

public interface CategoryImageService {
	public String getCategoryImage(int id);
	public List<CategoryImage> getCategoryImages();
}
