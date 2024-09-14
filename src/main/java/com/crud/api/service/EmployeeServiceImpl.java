package com.crud.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dto.EmployeeDTO;
import com.crud.api.exceptions.ResourceNotFoundException;
import com.crud.api.model.Employee;
import com.crud.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// save employee detail
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = dtoToModel(employeeDTO);
		Employee savedemployee = employeeRepository.save(employee);
		return modelToDTO(savedemployee);
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
		employeeRepository.delete(employee);

	}

	// get employee list
	@Override
	public List<EmployeeDTO> getemployeeList() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = employees.stream().map(emp -> modelToDTO(emp)).collect(Collectors.toList());
		return employeeDTOs;
	}

	// get employee by id
	@Override
	public EmployeeDTO getEmployeeById(Integer empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
		EmployeeDTO employeeDTO = modelToDTO(employee);
		return employeeDTO;

	}
	
	// update employee by id
	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));
		employee.setEmp_name(employeeDTO.getEmp_name());
		employee.setAge(employeeDTO.getAge());
		employee.setCity(employeeDTO.getCity());
		employee.setEmp_role(employeeDTO.getEmp_role());
		Employee updatedEmployee = employeeRepository.save(employee);
		return modelToDTO(updatedEmployee);
	}

	// convert dto to model
	private Employee dtoToModel(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmp_Id(employeeDTO.getEmp_Id());
		employee.setEmp_name(employeeDTO.getEmp_name());
		employee.setAge(employeeDTO.getAge());
		employee.setCity(employeeDTO.getCity());
		employee.setEmp_role(employeeDTO.getEmp_role());
		employee.setCreatedOnTimestamp(employeeDTO.getCreatedOnTimestamp());
		return employee;

	}

	// convert model to dto
	private EmployeeDTO modelToDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmp_Id(employee.getEmp_Id());
		employeeDTO.setEmp_name(employee.getEmp_name());
		employeeDTO.setAge(employee.getAge());
		employeeDTO.setCity(employee.getCity());
		employeeDTO.setEmp_role(employee.getEmp_role());
		employeeDTO.setCreatedOnTimestamp(employee.getCreatedOnTimestamp());
		return employeeDTO;

	}

	

}
