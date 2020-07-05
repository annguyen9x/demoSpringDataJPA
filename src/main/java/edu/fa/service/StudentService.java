package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;

@Service//để spring biết đây là một bean trong spring, mặc định tên bean = tenClass viết thường chữ đầu tiên
public class StudentService {
	
	@Autowired//Tự động inject bean (tiêm bean, hay truyền object) vào thuộc tính/ hàm dưới nó khi run app
	private StudentHibernateDao studentHibernateDao;
	
	public void save(Student st) {
		studentHibernateDao.save(st);
	}
	
}
