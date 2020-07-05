package edu.fa;

import javax.swing.Spring;
import javax.xml.crypto.Data;

import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;
import edu.fa.service.StudentService;

public class StudentManagementSpringDataJPA {

	public static void main(String[] args) {
		

		//Load file cấu hình "Spring Beand Configuration File" 
		//=> giống load file cấu hình Hibernate "hibernate.cfg.xml" là configuration.configure();
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("context.xml");
		/*
		//TH1: Thuần Hibernate trong Spring
		//Lấy ra một Bean 
		StudentHibernateDao studentHibernateDao = applicationContext.getBean("studentHibernateDao", StudentHibernateDao.class);
		
		//Thêm một Student vào DB
		studentHibernateDao.save(new Student("Ducky", "Ha Noi"));
		
		
		//Lấy ra tất cả Student trong Db
		System.out.println("Danh sách Student: " + studentHibernateDao.getAllStudent());
		*/
				
		//TH2: Spring Data JPA
		//Lấy ra một Bean 
		StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
		
		//Thêm một Student vào DB
		studentService.save(new Student("Clover", "HCM"));
		
		//Lấy ra tất cả Student trong Db
		
	}

}
