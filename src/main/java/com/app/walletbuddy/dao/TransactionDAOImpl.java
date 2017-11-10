package com.app.walletbuddy.dao;

import java.util.List;

import javax.sound.midi.Synthesizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.Transaction;
import com.app.walletbuddy.model.User;

public class TransactionDAOImpl implements TransactionDAO {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		
		t.setRealPrice(  t.getColor().indexOf("red")>-1 ? -1*t.getPrice() : t.getPrice()  );
		
		session.persist(t);
	}

	@Override
	public void updateTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		
		t.setRealPrice(  t.getColor().indexOf("red")>-1 ? -1*t.getPrice() : t.getPrice()  );
		
		session.update(t); 
	}

	@Override
	public List<Transaction> listTransactions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> transactionList = session.createQuery("from Transaction T  ORDER BY T.date desc").list();
		return transactionList;
	}
	@Override
	public List<Object[]> listTransactionsView(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select t.id, t.date, t.note, t.color, t.price, c.image, c.user_id, c.id AS catid, c.name from transactions t, categories c WHERE t.category_id=c.id AND c.user_id='"+userId+"'  ORDER BY t.date desc").list();
		
		return transactionList;
	}

	@Override
	public List<Object[]> listTransactionsViewLike(String pattern, int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select t.id, t.date, t.note, t.color, t.price, c.image, c.user_id, c.id AS catid, c.name from transactions t, categories c WHERE t.category_id=c.id AND c.user_id='"+userId+"' and t.note RLIKE '"+pattern+"'  ORDER BY t.date desc").list();
		
		return transactionList;
	}

	@Override
	public Transaction getTransactionById(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Transaction> transactionsList = session.createQuery("from Transaction T WHERE T.id='"+id+"'").list();
		if(transactionsList.size()>0)
			   return transactionsList.get(0);
			else return null;
	}

	@Override
	public void removeTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction t = new Transaction();
		t.setId(id);
		session.delete(t); 
	}
	@Override
	public void removeTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(t); 
	}

	@Override
	public List<Object[]> listTransactionsViewPriceBelow(float price, int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select t.id, t.date, t.note, t.color, t.price, c.image, c.user_id, c.id AS catid, c.name from transactions t, categories c WHERE t.category_id=c.id AND c.user_id='"+userId+"' and t.price < '"+price+"'  ORDER BY t.price desc").list();
		
		return transactionList;
	}

	@Override
	public List<Object[]> listTransactionsViewCategories(String pattern, int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select t.id, t.date, t.note, t.color, t.price, c.image, c.user_id, c.id AS catid, c.name from transactions t, categories c WHERE t.category_id=c.id AND c.user_id='"+userId+"' and c.name rlike '"+pattern+"'  ORDER BY c.name desc").list();
		
		return transactionList;
	}
	
	
	@Override
	public List<Object[]> listTransactionsMyWalletBallance( int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select sum(t.real_price), t.date from transactions t, categories c where t.category_id=c.id and c.user_id='"+userId+"' group by t.date order by t.date").list();
		
		return transactionList;
	}

	@Override
	public List<Object[]> listTransactionsMyWalletPositiveBallance(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select sum(t.real_price), t.date from transactions t, categories c where t.category_id=c.id and c.user_id='"+userId+"' and t.color='green' group by t.date order by t.date").list();
		
		return transactionList;
	}

	@Override
	public List<Object[]> listTransactionsSumByCategories(String catColor, int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionList = session.createSQLQuery("select sum(t.real_price), c.name from transactions t, categories c where t.category_id=c.id and c.user_id='"+userId+"' and t.color='"+catColor+"' group by c.name").list();
		
		return transactionList;
	}

	@Override
	public List<Transaction> listTransactionsByCategory(int catId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> transactionsList = session.createQuery("from Transaction T WHERE T.categoryId='"+catId+"'").list();
 
		return transactionsList;
	}

}
