package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
