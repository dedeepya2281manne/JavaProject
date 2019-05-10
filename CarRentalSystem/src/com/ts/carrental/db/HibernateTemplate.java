package com.ts.carrental.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Customer;



public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static
	{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserName(String cUsername) {
	String queryString = "from Customer where cUsername = :cUsername";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("cUsername", cUsername);
	  Object queryResult = query.uniqueResult();
	  Customer customer = (Customer)queryResult;
	  return customer; 
	}
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.merge(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Car> getCarListByQuery(String status) {
		String queryString = "from Car where status = :status";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("status", status);
		List<Car> queryResult = query.list();
		return queryResult;
	}

	public static List getCurrentBookedCars(int cId, String payment) {
		String queryString = "from Rent  rent where rent.customer.cId = :cId and rent.payment = :payment";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("payment", payment);
		query.setParameter("cId", cId);
		List<Car> queryResult = query.list();
		return queryResult;
	}

	public static List getPreviousBookedCars(int cId, String payment) {
		String queryString = "from Rent  rent where rent.customer.cId = :cId and rent.payment != :payment";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("payment", payment);
		query.setParameter("cId", cId);
		List<Car> queryResult = query.list();
		return queryResult;
	}
	
}
