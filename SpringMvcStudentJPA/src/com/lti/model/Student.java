package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope(scopeName="prototype")
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="roll_number")
	private int rollNumber;
	@Column(name="student_name")
	private String studentName;
	@Column(name="student_score")
	private double studentScore;
	
	@Autowired
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address; // = new Address();

	public Student() {
		super();
		System.out.println("Meri shaktiyon ka galat istemaal hua hai maa");
	}

	public Student(int rollNumber, String studentName, double studentScore) {
		System.out.println("Kabhi kabhi lagta hai apun hi bhagwan hai");
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(double studentScore) {
		this.studentScore = studentScore;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", studentScore=" + studentScore
				+ "]";
	}

}
