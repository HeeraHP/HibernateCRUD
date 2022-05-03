package com.heera.hibernate.crud.client;

import java.util.Set;

import com.heera.hibernate.crud.dao.StudentDao;
import com.heera.hibernate.crud.dao.StudentDaoImpl;
import com.heera.hibernate.crud.dto.Student;

public class Client {
    public static void main(String[] args) {
        
    	StudentDao dao = new StudentDaoImpl();
		
    /*	Student student1 = new Student("Ram", 'A');
		Student student2 = new Student("Sham", 'B');
		Student student3 = new Student("Seeta", 'A');
		Student student4 = new Student("Geeta", 'A');
		
		Integer rollNo1 = dao.addStudent(student1);
		Integer rollNo2 = dao.addStudent(student2);
		Integer rollNo3 = dao.addStudent(student3);
		Integer rollNo4 = dao.addStudent(student4);
		
		System.out.println("rollNo1 : " + rollNo1);
		System.out.println("rollNo2 : " + rollNo2);
		System.out.println("rollNo3 : " + rollNo3);
		System.out.println("rollNo4 : " + rollNo4);
		*/
    //	dao.updateStudent(1, 'B');
    //	dao.deleteStudent(4);
    	
    	Set<Student> allStudents = dao.getAllStudents();
		System.out.println(allStudents);
    	
     		
    }
}

