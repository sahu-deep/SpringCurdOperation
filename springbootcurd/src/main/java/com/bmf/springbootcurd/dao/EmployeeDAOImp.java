package com.bmf.springbootcurd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bmf.springbootcurd.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("From Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		//this id will give single object 
		Employee employeeObj=currentSession.get(Employee.class, id);
		if(employeeObj==null) {
			throw new RuntimeException("Employe with Id "+id+" does not exits in DAO");
		}
		return employeeObj;
	}

	@Override
	
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj=currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);

	}

	

}
