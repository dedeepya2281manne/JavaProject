package com.ts.carrental.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id@GeneratedValue
	private int cId;
	@Column(length=25)
	private String cName;
	@Column(length=25)
	private String cPhoneno;
	@Column(length=25)
	private String cEmailid;
	@Column(length=25)
	private String cUsername;
	@Column(length=25)
	private String cPassword;
	@Column(length=25)
	private String cAddress;
	
	@Column(length=25)
	private String cLicenseNo;
	
	public Customer(){
		super();
	}

	public Customer(String cName, String cPhoneno, String cEmailid, String cUsername, String cPassword, String cAddress,
			String cLicenseNo) {
		super();
		this.cName = cName;
		this.cPhoneno = cPhoneno;
		this.cEmailid = cEmailid;
		this.cUsername = cUsername;
		this.cPassword = cPassword;
		this.cAddress = cAddress;
		this.cLicenseNo = cLicenseNo;
	}
	public Customer(int cId, String cName, String cPhoneno, String cEmailid, String cUsername, String cPassword,
			String cAddress, String cLicenseNo) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhoneno = cPhoneno;
		this.cEmailid = cEmailid;
		this.cUsername = cUsername;
		this.cPassword = cPassword;
		this.cAddress = cAddress;
		this.cLicenseNo = cLicenseNo;
	}
	@OneToMany(mappedBy="customer")	
	private List <Rent>  rents =new ArrayList<Rent>();

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhoneno() {
		return cPhoneno;
	}
	public void setcPhoneno(String cPhoneno) {
		this.cPhoneno = cPhoneno;
	}
	public String getcEmailid() {
		return cEmailid;
	}
	public void setcEmailid(String cEmailid) {
		this.cEmailid = cEmailid;
	}
	public String getcUsername() {
		return cUsername;
	}
	public void setcUsername(String cUsername) {
		this.cUsername = cUsername;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcLicenseNo() {
		return cLicenseNo;
	}
	public void setcLicenseNo(String cLicenseNo) {
		this.cLicenseNo = cLicenseNo;
	}
	public List<Rent> getRents() {
		return rents;
	}
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
}
