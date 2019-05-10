package com.ts.carrental.dao;
import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.carrental.db.HibernateTemplate;
import com.ts.carrental.dto.Customer;



public class CustomerDao {
	
	private SessionFactory factory = null;
	
	public Customer getCustomer(String user) {
			return (Customer)HibernateTemplate.getObjectByUserName(user);
		}

		public int register(Customer customer) {
			return HibernateTemplate.addObject(customer);
		}

		public List<Customer> getAllCustomers() {
		List<Customer> customer=(List)HibernateTemplate.getObjectListByQuery("From Customer");
		System.out.println("Inside All Employees ..."+customer);
		return customer;	
		}
		public Customer getCustomer(int cid) {
			return (Customer)HibernateTemplate.getObject(Customer.class,cid);
		}
		
		public int update(Customer customer) {
		return HibernateTemplate.updateObject(customer);
	}
		public int delete(int cid) {
			return HibernateTemplate.deleteObject(Customer.class,cid);
		}

	}

