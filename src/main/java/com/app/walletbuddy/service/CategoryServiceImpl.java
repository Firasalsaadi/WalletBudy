package com.app.walletbuddy.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.walletbuddy.dao.CategoryDAO;
import com.app.walletbuddy.dao.CategoryImageDAO;
import com.app.walletbuddy.dao.TransactionDAO;
import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.Transaction;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	private CategoryImageDAO categoryImageDAO;
	public void setCategoryImageDAO(CategoryImageDAO categoryImageDAO) {
		this.categoryImageDAO = categoryImageDAO;
	}
	
	private TransactionDAO transactionDAO;  
	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	@Override
	@Transactional
	public void addCategory(Category c) {
		
		this.categoryDAO.addCategory(c);
	}

	@Override
	@Transactional
	public void updateCategory(Category c) {
		this.categoryDAO.updateCategory(c);
		
		List<Transaction> trans = this.transactionDAO.listTransactionsByCategory(c.getId());
		for(Transaction t : trans) {
			if(!t.getColor().equals(c.getColor())) {
				t.setRealPrice( t.getRealPrice()*-1 );
				t.setColor(c.getColor()); 
				this.transactionDAO.updateTransaction(t);
			}
		}
		
	}

	@Override
	@Transactional
	public List<Category> listCategory(int userId) {
		return this.categoryDAO.listCategory(userId);
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void removeCategory(int id) {
		
		List<Transaction> trans = this.transactionDAO.listTransactionsByCategory(id);
		for(Iterator<Transaction> it = trans.iterator(); it.hasNext(); ) {
			this.transactionDAO.removeTransaction(it.next()); 
		}
		this.categoryDAO.removeCategory(id);
	}

}
