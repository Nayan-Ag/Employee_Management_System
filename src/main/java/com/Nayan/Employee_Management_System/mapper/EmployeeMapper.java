package com.Nayan.Employee_Management_System.mapper;

import com.Nayan.Employee_Management_System.dto.EmployeeDTO;
import com.Nayan.Employee_Management_System.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),           
                employee.getEmail()
        );
    }
    
    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
    	return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),               
                employeeDTO.getEmail()
        );
    }
}
