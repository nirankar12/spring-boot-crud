package com.crud.api.dto;

import java.sql.Date;

public class EmployeeDTO {

	private int emp_Id;

	private String emp_name;

	private int age;

	private String city;

	private String emp_role;
	
	private Date createdOnTimestamp;

	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public Date getCreatedOnTimestamp() {
		return createdOnTimestamp;
	}

	public void setCreatedOnTimestamp(Date createdOnTimestamp) {
		this.createdOnTimestamp = createdOnTimestamp;
	}

}
