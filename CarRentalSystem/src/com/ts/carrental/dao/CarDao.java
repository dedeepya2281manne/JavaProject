package com.ts.carrental.dao;
import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.carrental.db.HibernateTemplate;
import com.ts.carrental.dto.Car;
public class CarDao {
		private SessionFactory factory = null;
			
			public int register(Car car) {
				return HibernateTemplate.addObject(car);
			}
			public List<Car> getAllCars() {
			List<Car> cars=(List)HibernateTemplate.getObjectListByQuery("From Car");
			return cars;	
		}
		public List<Car> getAvailableCars() {
			List<Car> cars=(List)HibernateTemplate.getCarListByQuery("available");
			return cars;	
		}
			public Car getCar(int carNo) {
				return (Car)HibernateTemplate.getObject(Car.class,carNo);
			}
			public int update(Car car) {
				return HibernateTemplate.updateObject(car);
			}

			public int delete(int carNo) {
				return HibernateTemplate.deleteObject(Car.class,carNo);
			}
		}


