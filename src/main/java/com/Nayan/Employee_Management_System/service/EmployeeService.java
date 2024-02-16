package com.Nayan.Employee_Management_System.service;

import java.util.List;

import com.Nayan.Employee_Management_System.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmployeeById(Long employeeId);
	
	List<EmployeeDTO> getAllEmployee();
	
	EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee);
	
	void deleteEmployee(Long employeeId);
}
