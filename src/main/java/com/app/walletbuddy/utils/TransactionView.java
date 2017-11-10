package com.app.walletbuddy.utils;

public class TransactionView {
	
	private String categoryName;
	
	private String image;
	
	private String date;
	
	private String note;
	
	private String price;
	
	private String color;
	
	private int categoryId;
	
	private int transactionId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "TransactionView [categoryName=" + categoryName + ", image=" + image + ", date=" + date + ", note="
				+ note + ", price=" + price + ", color=" + color + ", categoryId=" + categoryId + ", transactionId="
				+ transactionId + "]";
	}
	
}
