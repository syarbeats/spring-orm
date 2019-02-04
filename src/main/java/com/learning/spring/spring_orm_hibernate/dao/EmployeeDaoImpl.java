package com.learning.spring.spring_orm_hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring.spring_orm_hibernate.entity.Employee;

/*
 * DAO CLASS
 * **/
public class EmployeeDaoImpl implements IEmployeeDao {

	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	@Override
	public void addEmployee(Employee emp) {
		
		getSession().createSQLQuery("Insert into Employee(id, name, salary) Values(?, ?, ?)")
		.setParameter(1, emp.getId())
		.setParameter(2, emp.getName())
		.setParameter(3, emp.getSalary()).executeUpdate();
	}
	
	public Session getSession() {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		return session;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() {
		return getSession().createQuery("from Employee").list();
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
