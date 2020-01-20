package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import com.lti.model.Student;

public class StudentDaoImpl implements StudentDao {

	private static List<Student> students;

	public StudentDaoImpl() {
		students = new ArrayList<>();	// create collections using spring
	}

	public static List<Student> getStudents() {
		return students;
	}

	public static void setStudents(List<Student> students) {
		StudentDaoImpl.students = students;
	}

	@Override
	public int createStudent(Student student) {
		boolean result = students.add(student);
		if (result)
			return 1;
		else
			return 0;
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {
		for(Student s:students){
			if(s.getRollNumber()==rollNumber){
				return s;
			}
		}
		return null;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteStudentByRollNumber(int rollNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
