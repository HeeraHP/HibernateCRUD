package com.heera.hibernate.crud.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.heera.hibernate.crud.dto.Student;
import com.heera.hibernate.util.HibernateUtil;


public class StudentDaoImpl implements StudentDao{
	private SessionFactory factory;
	
	public StudentDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addStudent(Student student) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer rollNo = (Integer) session.save(student);
		
		txn.commit();
		session.close();
		return rollNo;
	}

	@Override
	public void updateStudent(int rollNo, char grade) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified roll no
		Student student = session.get(Student.class, rollNo);
		System.out.println("Before updation : " + student);
		// 2. update the object using setter method
		student.setGrade(grade);
		System.out.println("After updation : " + student);
		// 3. send the object back to the DB table
		session.update(student);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteStudent(int rollNo) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Student student = session.get(Student.class, rollNo);
		session.delete(student);
		
		txn.commit();
		session.close();
	}

	@Override
	public Set<Student> getAllStudents() {
		Set<Student> allStudents = null;
		// select * from studentdata;
		String hql = "from Student";
		
		Session session = factory.openSession();
		TypedQuery<Student> typedQuery = session.createQuery(hql);
		allStudents =  new HashSet<Student>(typedQuery.getResultList());
		
		session.close();
		return allStudents;
	}

}
