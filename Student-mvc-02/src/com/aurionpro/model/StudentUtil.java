package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class StudentUtil {

	public List<Student> getStudentList() {
		List<Student>Students=new ArrayList<>();
		Students.add(new Student(101,"Immanuel","immanuel@abc"));
		Students.add(new Student(102,"Rahul","igreenl@abc"));
		Students.add(new Student(103,"Apple","helloel@abc"));
		Students.add(new Student(104,"rizawan","immanuel@abc"));
		Students.add(new Student(105,"Immanuel","immanuel@abc"));
		
		return Students;
		
	}
}
