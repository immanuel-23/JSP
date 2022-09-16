package com.aurionpro.model;

public class Student {
	private String name;
	private int rollNo;
	private boolean merit;
	

	public Student(String name, int rollNo, boolean merit) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.merit = merit;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public boolean isMerit() {
		return merit;
	}


}
