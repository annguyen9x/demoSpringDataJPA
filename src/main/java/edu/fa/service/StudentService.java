package edu.fa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;
import edu.fa.repository.StudentRepository;

@Service//để spring biết đây là một bean trong spring, mặc định tên bean = tenClass viết thường chữ đầu tiên
public class StudentService {
	
	//TH1: Dùng Spring và Hibernate để thao tác DB
	/*@Autowired//Tự động inject bean (tiêm bean, hay truyền object) vào thuộc tính/ hàm dưới nó khi run app, phải có @Service,.. ở tên class để đánh dấu là bean
	private StudentHibernateDao studentHibernateDao;
	
	//C1: Sử dụng các p.thức đã xây dựng trong studentHibernateDao của Hiberanate (không phải Sring Data JPA)
	public void save(Student st) {
		studentHibernateDao.save(st);
	}*/
	
	//TH2: Dùng Spring Data JPA để thao tác DB
	//TH2.1: Dùng hàm có sẵn của JpaRepos1tory
	@Autowired//Tự động inject bean (tiêm bean, hay truyền object) vào thuộc tính/ hàm dưới nó khi run app, phải có @Service,.. ở tên class để đánh dấu là bean
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		//Sử dụng hàm có sẵn khi kế thừa interface "JpaRepository" để thao tác với DB mà không cần xd như Hibernate
		studentRepository.save(student);
	}
	
	public long count() {
		return studentRepository.count();
	}
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	//TH2.2: Truy vấn theo Query Method: tên hàm theo tên các thuộc tính của đối tượng,
	//để truy vấn theo điều kiện của các thuộc tính đó
	
	//1. Truy vấn theo điều kiện: tên và loaction
	public Student getStudentByNameAndLocation() {
		return studentRepository.findByNameAndLocation("Clover", "HCM");
	}
	
	//Truy vấn theo Query Method: tên hàm theo tên các thuộc tính của đối tượng,
	//để truy vấn theo điều kiện của các thuộc tính đó
	//2. Truy vấn theo điều kiện: tên hoặc loaction
	public Student getStudentByNameOrLocation() {
		return studentRepository.findByNameOrLocation("Clover", "HaNoi-HCM");
	}
	
	//TH2.3: Truy vấn theo Query <-> @Query 
	public List<Student> getAllStudentByNameABC(String name) {
		return studentRepository.getAllStudentByNameABC(name);
	}
}
