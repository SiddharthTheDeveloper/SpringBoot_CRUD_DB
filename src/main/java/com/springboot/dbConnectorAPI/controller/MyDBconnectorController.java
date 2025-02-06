package com.springboot.dbConnectorAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dbConnectorAPI.Entity.Employee;
import com.springboot.dbConnectorAPI.service.DBConnectorService;
import com.springboot.dbConnectorAPI.service.DBConnectorServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MyDBconnectorController {

	@Autowired
	DBConnectorService service;

//Method to insert Single record in the database
	@PostMapping("/emp")
	public Employee addEmployee(@RequestBody Employee e) {
		System.out.println("Inside Post Single records");
		System.out.println("e controller" + e.getEmpId());
		return service.addemployee(e);
	}

//Method to insert multiple record in the database
	@PostMapping("/multiRecords")
	public ResponseEntity<HttpStatus> addmultirecords(@RequestBody List<Employee> employee) {
		try {
			System.out.println("Inside Post Multirecords");
			service.addmultirecords(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

//Method to get Single employee
	@GetMapping("/emp/{empId}")
	public Optional<Employee> getSingleEmployee(@PathVariable long empId) {
		return service.getSingleEmployee(empId);
	}

//Method to get multiple employees
	@GetMapping("/emp")
	public List<Employee> getMultipleEmployee() {
		return service.getMultipleEmployee();
	}
//Method to update employee
	@PutMapping("/emp")
	public Employee updateEmployee(@RequestBody Employee e) {
		System.out.println("Inside updatEmployee method in Controller");
		return service.updateEmployee(e);
	}
	@DeleteMapping("/emp/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long empId)
	{
		try {
		service.deleteEmployeeService(empId);
		return ResponseEntity.ok("Employee deleted");
		}
		catch (Exception e)
		{
		return 	(ResponseEntity<String>) ResponseEntity.notFound();
		}
	}
	{
		
	}
}
