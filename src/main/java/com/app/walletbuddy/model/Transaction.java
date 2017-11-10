package com.app.walletbuddy.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="note")
	private String note;
	
	@Column(name="price")
	private float price;
	
	@Column(name="color")
	private String color;

	@Column(name="real_price")
	private float realPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDate() {
		String tmpArr[] = date.toString().split("-");
		return tmpArr[2] + "-" + tmpArr[1] + "-" + tmpArr[0];
	}

	public void setDate(String date) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = df.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(udate.getTime());
		
		this.date = sqlDate;
	}
	
	public Date getDateSQL() {
		return date;
	}
	
	public void setDateSQL(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = Float.parseFloat( String.format("%.02f", price) );
		System.out.println(price+" "+ this.price+" "+String.format("%.02f", price));
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", categoryId=" + categoryId + ", date=" + date + ", note=" + note + ", price="
				+ price + ", color=" + color + ", realPrice=" + realPrice + "]";
	}
	
}
