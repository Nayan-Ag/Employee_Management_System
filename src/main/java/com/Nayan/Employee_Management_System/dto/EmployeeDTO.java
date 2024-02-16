package com.Nayan.Employee_Management_System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	private Long id;
	private String lastName;
	private String firstName;
	private String email;
	
}
