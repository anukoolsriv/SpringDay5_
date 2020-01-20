package com.lti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student =new Student();
		
		student.setRollNumber(rs.getInt("roll_number"));
		student.setStudentName(rs.getString("student_name"));
		student.setStudentScore(rs.getDouble("student_score"));

		return student;
	}
}
