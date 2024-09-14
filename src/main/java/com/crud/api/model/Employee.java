package com.crud.api.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_Id;

	@Column(name = "employee_name")
	private String emp_name;

	@Column(name = "employee_age")
	private int age;

	@Column(name = "city_name")
	private String city;

	@Column(name = "employee_role")
	private String emp_role;

	@Column(name = "createdOnTimestamp")
	@CreationTimestamp
	private Date createdOnTimestamp;

	public Employee() {
	}

	public Employee(int emp_Id, String emp_name, int age, String city, String emp_role, Date createdOnTimestamp) {
		super();
		this.emp_Id = emp_Id;
		this.emp_name = emp_name;
		this.age = age;
		this.city = city;
		this.emp_role = emp_role;
		this.createdOnTimestamp = createdOnTimestamp;
	}

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
