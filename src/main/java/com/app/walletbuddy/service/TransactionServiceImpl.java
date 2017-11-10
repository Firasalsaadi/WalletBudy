package com.app.walletbuddy.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.walletbuddy.dao.TransactionDAO;
import com.app.walletbuddy.dao.UserDAO;
import com.app.walletbuddy.model.Transaction;
import com.app.walletbuddy.model.User;
import com.app.walletbuddy.utils.Helper;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO;  
	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	
	private UserDAO userDAO;  
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addTransaction(Transaction t, int userId) {
		this.transactionDAO.addTransaction(t);
		User u = this.userDAO.getUserById(userId);
		
		float tAmount = t.getColor().indexOf("red")>-1 ? 0 - t.getPrice() : t.getPrice();
		u.updateWallet(tAmount);
		
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public void updateTransaction(Transaction t, int userId) {
		Transaction oldT = this.transactionDAO.getTransactionById(t.getId());
		float oldAmount = oldT.getColor().indexOf("red")>-1 ? 0 - oldT.getPrice() : oldT.getPrice();
		float newAmount = t.getColor().indexOf("red")>-1 ? 0 - t.getPrice() : t.getPrice();
		float amountToAdd = newAmount - oldAmount;
		oldT.setPrice(t.getPrice());
		oldT.setCategoryId(t.getCategoryId());
		oldT.setDateSQL(t.getDateSQL());
		oldT.setNote(t.getNote());
		oldT.setColor(t.getColor());
		
		
		
		User u = this.userDAO.getUserById(userId);
		u.updateWallet(amountToAdd);
		this.transactionDAO.updateTransaction(oldT);
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<Transaction> listTransactions() {
		return this.transactionDAO.listTransactions();
	}

	@Override
	@Transactional
	public Transaction getTransactionById(int id) {
		return this.transactionDAO.getTransactionById(id);
	}

	@Override
	@Transactional
	public void removeTransaction(int id) {
		this.transactionDAO.removeTransaction(id);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsView(int userId) {
		return this.transactionDAO.listTransactionsView(userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsViewLike(String pattern, int userId) {
		return this.transactionDAO.listTransactionsViewLike(pattern, userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsViewPriceBelow(float price, int userId) {
		return this.transactionDAO.listTransactionsViewPriceBelow(price, userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsViewCategories(String pattern, int userId) {
		return this.transactionDAO.listTransactionsViewCategories(pattern, userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsMyWalletBallance(int userId) {
		return this.transactionDAO.listTransactionsMyWalletBallance(userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsMyWalletPositiveBallance(int userId) {
		return this.transactionDAO.listTransactionsMyWalletPositiveBallance(userId);
	}

	@Override
	@Transactional
	public List<Object[]> listTransactionsSumByIncomeCategories(int userId) {
		return this.transactionDAO.listTransactionsSumByCategories("green", userId);
	}
	@Override
	@Transactional
	public List<Object[]> listTransactionsSumByExpenceCategories(int userId) {
		return this.transactionDAO.listTransactionsSumByCategories("red", userId);
	}

	@Override
	@Transactional
	public List<Transaction> listTransactionsByCategory(int catId) {
		return this.transactionDAO.listTransactionsByCategory(catId);
	}

}
