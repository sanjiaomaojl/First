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
		
		//1.获取session
		Session session = HbnUtils.getSession();
		try {
			//2.开启事务
			session.beginTransaction();
		
			//3.操作
		     Course course1 = new Course("struts2");
		     Course course2 = new Course("hibernate5");
		     Course course3 = new Course("spring4");
		     
		     Student student1 = new Student("张三");
		     Student student2 = new Student("李四");
			 
		     student1.getCourses().add(course1);
		     student1.getCourses().add(course2);
		     
		     student2.getCourses().add(course1);
		     student2.getCourses().add(course3);
			
			 session.save(student1);
			 session.save(student2);
			
			//4.提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
		@Test
		
		public void test02(){
			
			//1.获取session
			Session session = HbnUtils.getSession();
			try {
				//2.开启事务
				session.beginTransaction();
				
				//3.操作
				Student student1 = new Student("张三");
				Student student2 = new Student("李四");
				
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
				
				
				//4.提交事务
				session.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//5.事务回滚
				session.getTransaction().rollback();
			}
		
	}
		
	
}
