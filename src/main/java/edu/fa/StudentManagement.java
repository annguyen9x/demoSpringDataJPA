package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;

public class StudentManagement {

	public static void main(String[] args) {
		

		//Load file cấu hình "Spring Beand Configuration File" 
		//=> giống load file cấu hình Hibernate "hibernate.cfg.xml" là configuration.configure();
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("context.xml");
		
		//Lấy ra một Bean 
		StudentHibernateDao studentHibernateDao = applicationContext.getBean("studentHibernateDao", StudentHibernateDao.class);
		
		//Thêm một Student vào DB
		studentHibernateDao.save(new Student("Ducky", "Ha Noi"));
		
		
		//Lấy ra tất cả Student trong Db
		System.out.println("Danh sách Student: " + studentHibernateDao.getAllStudent());
		
	}

}
