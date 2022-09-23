package com.aurionpro.model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String email;
	private int id;
	private String department ;
	private int salary;
	private double salaryPerAnum;
	
	public Employee(String firstName, String lastName, String email, int id, String department, int salary,double salaryPerAnum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
		this.department = department;
		this.salary = salary;
		this.salaryPerAnum=salaryPerAnum;
	}
	
	public Employee(String firstName, String lastName, String email, String department, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}

	public Employee(String fName, String lName, String email, int id, String dept, int salary) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
		this.id=id;
		this.department = dept;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id
				+ ", department=" + department + ", salary=" + salary + "]";
	}
	
	
}
