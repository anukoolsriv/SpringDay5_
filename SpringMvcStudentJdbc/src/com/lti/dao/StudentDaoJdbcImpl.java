package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Student;

@Repository
public class StudentDaoJdbcImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String CREATE_STUDENT = "insert into student (Roll_Number,Student_Name,Student_Score) values(?,?,?)";
	private static final String READ_STUDENT = "select * from student where Roll_Number = ?";
	private static final String UPDATE_STUDENT = "update student set student_name = ?, student_score = ? where roll_number = ?";
	private static final String DELETE_STUDENT="delete from student where roll_number=?";
	private static final String SELECT_ALL_STUDENTS = "select * from student";

	@Override
	public int createStudent(Student student) {
		int inserted = jdbcTemplate.update(CREATE_STUDENT, student.getRollNumber(), student.getStudentName(), student.getStudentScore());
		return inserted;
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {
//		List<Student> students = jdbcTemplate.query(READ_STUDENT, new StudentRowMapper());
		Student student = jdbcTemplate.queryForObject(READ_STUDENT, new StudentRowMapper(), rollNumber);
//		Student student = jdbcTemplate.queryForObject(READ_STUDENT, new Object[]{rollNumber}, new StudentRowMapper());
		return student;
	}
	
	@Override
	public int updateStudent(Student student){
		int updated = jdbcTemplate.update(UPDATE_STUDENT,student.getStudentName(), student.getStudentScore(), student.getRollNumber());
		return updated;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int DeleteStudentByRollNumber(int rollNumber) {
		int deleted=jdbcTemplate.update(DELETE_STUDENT, rollNumber);
		return deleted;
	}

	@Override
	public List<Student> getAllStudents() {
		 List<Student> students = jdbcTemplate.query(SELECT_ALL_STUDENTS, new StudentRowMapper());
		return students;
	}

}
