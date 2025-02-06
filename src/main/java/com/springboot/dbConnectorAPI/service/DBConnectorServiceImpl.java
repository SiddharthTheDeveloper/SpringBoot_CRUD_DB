package com.springboot.dbConnectorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.dbConnectorAPI.Dao.DBConnectorDao;
import com.springboot.dbConnectorAPI.Entity.Employee;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DBConnectorServiceImpl implements DBConnectorService {

	@Autowired
	DBConnectorDao dao;

	public DBConnectorServiceImpl() {

	}

	@Override
	public Employee addemployee(Employee e) {
		System.out.println("Inside impl");
		
		try {
			dao.save(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public void addmultirecords(List<Employee> employee) {
		System.out.println("Inside addmultirecords");
		try {
			dao.saveAll(employee);
			System.out.println("Inside try");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Optional<Employee> getSingleEmployee(long empid) {

		Optional<Employee> employee = null;
		try {
			employee = dao.findById(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getMultipleEmployee() {
		List l1 = null;
		try {
			l1 = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l1;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1 = null;
		try {
			System.out.println("Inside updatEmployee method in service");
			e1 = dao.save(e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e1;
	}

	public void deleteEmployeeService(long empId) {
		
		System.out.println("empId=" + empId);
			if (dao.existsById(empId))
			{
				System.out.println("Inside if of deleteEmployeeService method in service");
				dao.deleteById(null);
			}
			
	}
}
