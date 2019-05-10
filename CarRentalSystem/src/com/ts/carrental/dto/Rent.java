package com.ts.carrental.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent {
	@Id@GeneratedValue
	private int receiptNo;
	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getMeterReading() {
		return meterReading;
	}

	public void setMeterReading(int meterReading) {
		this.meterReading = meterReading;
	}

	public int getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(int costPerKm) {
		this.costPerKm = costPerKm;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	@Column(length=25)
	private Date rentDate;
	@Column(length=25)
	private Date returnDate;
	@Column(length=25)
	private int amount;
	@Column(length=25)
	private String payment;
	@Column(length=25)
	private int meterReading;
	@Column(length=25)
	private int costPerKm;
	
	public Rent(Date rentDate, Date returnDate, int amount, String payment, int meterReading, int costPerKm,
			Customer customer, Car car) {
		super();
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.amount = amount;
		this.payment = payment;
		this.meterReading = meterReading;
		this.costPerKm = costPerKm;
		this.customer = customer;
		this.car = car;
	}

	public Rent(Date rentDate, Date returnDate, int amount, String payment, int meterReading, int costPerKm) {
		super();
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.amount = amount;
		this.payment = payment;
		this.meterReading = meterReading;
		this.costPerKm = costPerKm;
	}
	@ManyToOne
	//@MapsId("cId")
	@JoinColumn(name="cId")
	private Customer customer;
	@ManyToOne
	//@MapsId("carNo")
	@JoinColumn(name="carNo")
    private Car car;
	public Rent() {
		super();
	}
	
	
}
