package com.learning.spring.spring_orm_hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_orm_hibernate.entity.Employee;

/*
 * DAO CLASS
 * **/
public class EmployeeDaoImpl implements IEmployeeDao {

	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() {
		
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		return session.createQuery("from Employee").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
