package com.app.walletbuddy.dao;

import java.util.List;

import com.app.walletbuddy.model.Transaction;

public interface TransactionDAO {
	
	public void addTransaction(Transaction t);
	public void updateTransaction(Transaction t);
	public List<Transaction> listTransactions();
	public List<Transaction> listTransactionsByCategory(int catId);
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
	void removeTransaction(Transaction t);
	
	List<Object[]> listTransactionsView(int userId);
	List<Object[]> listTransactionsViewLike(String pattern, int userId);
	List<Object[]> listTransactionsViewPriceBelow(float price, int userId);
	List<Object[]> listTransactionsViewCategories(String pattern, int userId);
	
	
	public List<Object[]> listTransactionsMyWalletBallance( int userId) ;
	public List<Object[]> listTransactionsMyWalletPositiveBallance( int userId) ;
	List<Object[]> listTransactionsSumByCategories(String catColor, int userId);
	
}
