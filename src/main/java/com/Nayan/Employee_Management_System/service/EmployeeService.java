package com.Nayan.Employee_Management_System.service;

import com.Nayan.Employee_Management_System.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getEmployeeById(Long employeeId);
}
