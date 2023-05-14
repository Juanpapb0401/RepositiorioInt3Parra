package model;

import java.util.Calendar;

public class Transaction {

    private Calendar date;
	private double purchaseValue;
	private String nameBooks;

	public Transaction(double purchaseValue, String nameBooks) {

		this.date = Calendar.getInstance();
		this.purchaseValue = purchaseValue;
		this.nameBooks= nameBooks;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public Calendar calculateDateSold(){
		return Calendar.getInstance();
	}

	public String getNameBooks() {
		return nameBooks;
	}

	public void setNameBooks(String nameBooks) {
		this.nameBooks = nameBooks;
	}

}
