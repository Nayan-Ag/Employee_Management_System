package com.Nayan.Employee_Management_System.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nayan.Employee_Management_System.dto.EmployeeDTO;
import com.Nayan.Employee_Management_System.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
	}
	
	//Build Get Employee By ID REST API
	@GetMapping("{Id}")
	public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable("Id") Long employeeId){
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDTO);
	}
	
	// Build Get All Employees REST API 
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		List<EmployeeDTO> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}
	
	//Build Update Employee REST API
	@PutMapping("{Id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("Id")Long employeeId , @RequestBody EmployeeDTO updateEmployee){
		EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updateEmployee);
		return ResponseEntity.ok(employeeDTO);
	}
	
	// Build Delete EMployee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long EmployeeId){
		employeeService.deleteEmployee(EmployeeId);
		return ResponseEntity.ok("Employee Deleted Succesfully");
	}
}
