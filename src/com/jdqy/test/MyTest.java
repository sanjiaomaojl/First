package com.jdqy.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import com.jdqy.beans.Course;
import com.jdqy.beans.Student;

import com.jdqy.utils.HbnUtils;

public class MyTest {
	
	@Test
	
	public void test01(){
		
		//1.��ȡsession
		Session session = HbnUtils.getSession();
		try {
			//2.��������
			session.beginTransaction();
		
			//3.����
		     Course course1 = new Course("struts2");
		     Course course2 = new Course("hibernate5");
		     Course course3 = new Course("spring4");
		     
		     Student student1 = new Student("����");
		     Student student2 = new Student("����");
			 
		     student1.getCourses().add(course1);
		     student1.getCourses().add(course2);
		     
		     student2.getCourses().add(course1);
		     student2.getCourses().add(course3);
			
			 session.save(student1);
			 session.save(student2);
			
			//4.�ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//5.����ع�
			session.getTransaction().rollback();
		}
	}
		@Test
		
		public void test02(){
			
			//1.��ȡsession
			Session session = HbnUtils.getSession();
			try {
				//2.��������
				session.beginTransaction();
				
				//3.����
				Student student1 = new Student("����");
				Student student2 = new Student("����");
				
				Course course1 = new Course("struts2");
				Course course2 = new Course("hibernate5");
				Course course3 = new Course("spring4");
				
			
				
				course1.getStudents().add(student1);
				course1.getStudents().add(student2);
				
				course2.getStudents().add(student1);
				
				course3.getStudents().add(student2);
				
				
				
				session.save(course1);
				session.save(course2);
				session.save(course3);
				
				
				//4.�ύ����
				session.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//5.����ع�
				session.getTransaction().rollback();
			}
		
	}
		
	
}
