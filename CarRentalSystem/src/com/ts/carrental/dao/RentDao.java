package com.ts.carrental.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.carrental.db.HibernateTemplate;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Rent;

public class RentDao {

	private SessionFactory factory = null;
	

	public int register(Rent rent) {
		return HibernateTemplate.addObject(rent);
	}

	public List<Rent> getAllRents() {
	List<Rent> rents=(List)HibernateTemplate.getObjectListByQuery("From Rent");
	return rents;	
}

	public List<Rent> getCurrentBookedCars(int cId, String payment) {
		List<Rent> rents=(List)HibernateTemplate.getCurrentBookedCars(cId, payment);
		return rents;	
	}
	public Rent getRent(int receiptNo) {
		return (Rent)HibernateTemplate.getObject(Rent.class,receiptNo);
	}
	
	public int update(Rent rent) {
		return HibernateTemplate.updateObject(rent);
	}

	public List<Rent> getPreviousBookedCars(int cId, String payment) {
		List<Rent> rents=(List)HibernateTemplate.getPreviousBookedCars(cId, payment);
		return rents;
	}

}