package com.example.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	
	public Student(long id, String studentName, String studentEmail, String studentAddress) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}
	public Student() {
		super();
	}
	
	
    
}
