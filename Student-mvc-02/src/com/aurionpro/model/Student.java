package com.aurionpro.model;

public class Student {
	private  int rollNo;
	private String name;
	private String email;
	
	
	public Student(int rollNo, String name, String email) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
	}

	public int getRollNo() {
		return rollNo;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	
	
	
	
}
