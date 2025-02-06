package com.springboot.dbConnectorAPI.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.dbConnectorAPI.Entity.Employee;

public interface DBConnectorDao extends JpaRepository<Employee, Long>  {

}
