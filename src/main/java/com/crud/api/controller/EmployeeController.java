package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.dto.EmployeeDTO;
import com.crud.api.service.EmployeeService;

@RestController
@RequestMapping("crud/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/test")
	public String test() {
		return "CRUD api in spring boot";
	}
	
	// save employee detail
	@PostMapping("/create-employee")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO saved = employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	// get all employees details
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> employeesList(){
		return new ResponseEntity<>(employeeService.getemployeeList(), HttpStatus.OK);
	}
	
	// get employee by id
	@GetMapping("/employees/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("empId") Integer empId){
		return new ResponseEntity<>(employeeService.getEmployeeById(empId), HttpStatus.OK);
		
	}
	
	// update employee by id
	@PutMapping("employee/update/{empId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, 
			@PathVariable("empId") Integer empId){
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeDTO, empId);
				return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		
	}
	
	// delete employee by id
	@DeleteMapping("/employee/delete/{empId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("empId") Integer empId){
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.GONE);
	} 
}
