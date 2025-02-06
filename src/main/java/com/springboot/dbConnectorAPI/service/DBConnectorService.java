package com.springboot.dbConnectorAPI.service;

import java.util.List;
import java.util.Optional;

import com.springboot.dbConnectorAPI.Entity.Employee;

public interface DBConnectorService {


	public Employee addemployee(Employee e);

	public void addmultirecords(List<Employee> employee);

	public Optional<Employee> getSingleEmployee(long empid);

	public List<Employee> getMultipleEmployee();

	public Employee updateEmployee(Employee e);

	public void deleteEmployeeService(long empId);

}
