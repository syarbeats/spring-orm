package com.learning.spring.spring_orm_hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.spring_orm_hibernate.dao.EmployeeDaoImpl;
import com.learning.spring.spring_orm_hibernate.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx =  new ClassPathXmlApplicationContext("META-INF/application-context.xml");
    	/*
         * DAO USING COMMON HIBERNATE CLASS
         * **/
        EmployeeDaoImpl empDaoImpl = (EmployeeDaoImpl) ctx.getBean("employeeDaoImpl");
        List<Employee> empList = empDaoImpl.getEmployeeList();
        
        System.out.println("Spring-ORM-Using-Hibernate");
        
        for(Employee employee:empList) {
     	   System.out.println("Employee:"+employee.getName()+", Salary:"+employee.getSalary());
        }
        
    }
}
