package com.Nayan.Employee_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Nayan.Employee_Management_System.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee , Long>{
	
}
