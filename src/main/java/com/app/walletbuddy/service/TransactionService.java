package com.app.walletbuddy.service;

import java.util.List;

import com.app.walletbuddy.model.Transaction;

public interface TransactionService {
	
	public void addTransaction(Transaction t, int userId);
	public void updateTransaction(Transaction t, int userId);
	public List<Transaction> listTransactions();
	public List<Transaction> listTransactionsByCategory(int catId);
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
	
	List<Object[]> listTransactionsView(int userId);
	List<Object[]> listTransactionsViewLike(String pattern, int userId);
	List<Object[]> listTransactionsViewPriceBelow(float price, int userId);
    List<Object[]> listTransactionsViewCategories(String pattern, int userId);
    
    public List<Object[]> listTransactionsMyWalletBallance( int userId) ;
    public List<Object[]> listTransactionsMyWalletPositiveBallance( int userId) ;
	List<Object[]> listTransactionsSumByExpenceCategories(int userId);
	List<Object[]> listTransactionsSumByIncomeCategories(int userId);
}
