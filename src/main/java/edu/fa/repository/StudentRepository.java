package edu.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.Student;

//Các class trong "repository" tương tự các class trong lớp "dao" của Hibernate,
//nhưng các class trong "repository" của Spring Data JPA kế thừa interface "JpaRepository"
//nên s/ dụng các hàm có sẵn của nó mà không cần xd như các class lớp "dao" của Hibernate

//Không cần @Repository vì cấu hình <jpa:repositories..> nên nó quét đến đây, 
//còn khai báo <context:component-scan> cần dùng @Component, @Repository,..
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//Sẽ kế thừa các hàm có sẵn của interface "JpaRepository" để thao tác với DB mà không cần xd như Hibernate
	
	//Các hàm Query method: Hàm truy vấn DB dựa theo tên các thuộc tính của đối tượng để truy vấn theo đk của các thuộc tính
	//tên hàm (theo quy ước đặt tên trong spring Data JPA)
	Student findByNameAndLocation(String name, String location);
	//Hàm tìm và trả về đối tượng "Student" theo điều kiện: Name = name truyền vào "và" Location = location truyền vào
	
	Student findByNameOrLocation(String name, String location);
	//Hàm tìm và trả về đối tượng "Student" theo điều kiện: Name = name truyền vào "hoặc" Location = location truyền vào
	
	@Query("Select s From Student s Where s.name = ?")
	List<Student> getAllStudentByNameABC(String name);
	
}
