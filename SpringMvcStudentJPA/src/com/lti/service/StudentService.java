package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student findStudentByRollNumber(int rollNumber);
	List<Student> getAllStudents();
	public boolean updateStudent(Student student);
	boolean deleteStudent(int rollNumber);

}
