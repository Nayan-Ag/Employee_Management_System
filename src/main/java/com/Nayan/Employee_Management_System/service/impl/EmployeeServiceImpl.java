package com.Nayan.Employee_Management_System.service.impl;

import com.Nayan.Employee_Management_System.dto.EmployeeDTO;
import com.Nayan.Employee_Management_System.entity.Employee;
import com.Nayan.Employee_Management_System.exception.ResourceNotFoundException;
import com.Nayan.Employee_Management_System.mapper.EmployeeMapper;
import com.Nayan.Employee_Management_System.repository.EmployeeRepository;
import com.Nayan.Employee_Management_System.service.EmployeeService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = employeeRepository.save(employee);
		
		
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}
	
	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with the given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployee(){
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with the given id : " + employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
	}
}
