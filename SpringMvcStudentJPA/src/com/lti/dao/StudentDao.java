package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public Student readStudentByRollNumber(int rollNumber);
	public int updateStudent(Student student);
	public int DeleteStudentByRollNumber(int rollNumber);
	public List<Student> getAllStudents();
}
