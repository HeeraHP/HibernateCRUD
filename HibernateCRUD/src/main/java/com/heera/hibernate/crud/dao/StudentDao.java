package com.heera.hibernate.crud.dao;

import java.util.Set;

import com.heera.hibernate.crud.dto.Student;

public interface StudentDao {
	
	public Integer addStudent(Student student);
	public void updateStudent(int rollNo, char grade);
	public void deleteStudent(int rollNo);
	public Set<Student> getAllStudents();

}
