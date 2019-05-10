package com.ts.carrental.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Car {
	@Id@GeneratedValue
	private int carNo;
	@Column(length=25)
	private String carModel;
	@Column(length=25)
	private String carColor;
	@Column(length=25)
	private String status;
	@Column(length=25)
	private int capacity;
	@Column(length=25)
	private int basePrice;
	@Column(length=25)
	private int costPerKm;
	@Column(length=25)
	private int penality;
	@Column(length=25)
	private String image;
	
	
	
	public Car(String carModel, String carColor, String status, int capacity, int basePrice, int costPerKm,
			int penality, String image) {
		super();
		this.carModel = carModel;
		this.carColor = carColor;
		this.status = status;
		this.capacity = capacity;
		this.basePrice = basePrice;
		this.costPerKm = costPerKm;
		this.penality = penality;
		this.image = image;
		
	}
	public Car(int carNo, String carModel, String carColor, String status, int capacity, int basePrice, int costPerKm,
			int penality, String image) {
		super();
		this.carNo = carNo;
		this.carModel = carModel;
		this.carColor = carColor;
		this.status = status;
		this.capacity = capacity;
		this.basePrice = basePrice;
		this.costPerKm = costPerKm;
		this.penality = penality;
		this.image = image;
		
	}
	public Car(){
		super();
	}
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public int getCostPerKm() {
		return costPerKm;
	}
	public void setCostPerKm(int costPerKm) {
		this.costPerKm = costPerKm;
	}
	public int getPenality() {
		return penality;
	}
	public void setPenality(int penality) {
		this.penality = penality;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@OneToMany(mappedBy="car")	
	private List <Rent>  rents =new ArrayList<Rent>();
	
	public void setRents(List<Rent> rents) {
		this.rents=rents;
	}
	public List<Rent> getRents() {
		return rents;
	}

	
	
}
