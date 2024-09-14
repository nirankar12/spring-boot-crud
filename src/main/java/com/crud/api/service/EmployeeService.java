package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
	
	public void deleteEmployee(Integer empId);
	
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer empId);
	
	public List<EmployeeDTO> getemployeeList();
	public EmployeeDTO getEmployeeById(Integer empId );

}
