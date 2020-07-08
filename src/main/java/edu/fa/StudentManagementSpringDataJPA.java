package edu.fa;


import java.util.List;

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
		
		//Thêm một Student vào DB->Dùng hàm có sẵn của JpaRepository
		studentService.save(new Student("Clover", "HCM"));
		
		//Lấy ra tất cả Student trong Db->Dùng hàm có sẵn của JpaRepository
		List<Student> studentsList = studentService.getAllStudent();
		System.out.println("Danh sách Student: " + studentsList);
		
		//Đếm số Student trong DB->Dùng hàm có sẵn của JpaRepository
		long numberOfStudent  = studentService.count();
		System.out.println("Số Student: " + numberOfStudent);
		
		//Lấy ra tất cả Student có Name=name "và" Location = location->Dùng Query Method của JpaRepository
		Student student2 = studentService.getStudentByNameAndLocation();
		System.out.println("Student truy vấn theo Name 'và' Location: " + student2);
		
		//Lấy ra tất cả Student có Name=name "hoặc" Location = location->Dùng Query Method của JpaRepository
		Student student3 = studentService.getStudentByNameOrLocation();
		System.out.println("Student truy vấn theo Name 'hoặc' Location: " + student3);
		
		//Lấy ra tất cả Student theo name = name -> Dùng @Query 
		List<Student> students = studentService.getAllStudentByNameABC("Clover");
		System.out.println("@Query: Student truy vấn theo Name: " + students);

	}

}
