package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	public StudentDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}

	@Override
	public int createStudent(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		return 1;
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {

		return entityManager.find(Student.class, rollNumber);
	}

	@Override
	public int updateStudent(Student student) {

		return 0;
	}

	@Override
	public int DeleteStudentByRollNumber(int rollNumber) {

		return 0;
	}

	@Override
	public List<Student> getAllStudents() {
		String jpql = "From Student";
		TypedQuery<Student> typed = entityManager.createQuery(jpql, Student.class);

		return typed.getResultList();
	}

}
