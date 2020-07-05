package edu.fa.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;


@Component//Để spring hiểu đây là một Bean và load khi run app, @Component tương tự @Repository, @Server,..
public class StudentHibernateDao {
	
	//@Autowire // vì đã cấu hình trong file cấu hình bean "context.xml", 
	//nên để nó Inject Bean (tiêm Bean- tức là truyền Object "SessionFactory") vào thuộc tính "sessionFactory" khi run app
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//Hàm thêm Student
	public void save(Student student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();//Bắt đầu một giao dịch hay bắt đầu vòng đời Session
		session.save(student);
		session.getTransaction().commit();//Đầy Object lên DB
		session.close();//Đóng tài nguyên Session
	}
	
	//Hàm lấy ra tất cả Student
	public List<Student> getAllStudent() {
		List<Student> listSt = null;
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();//Bắt đầu một giao dịch hay bắt đầu vòng đời Session
			Query query = session.createQuery("FROM Student");
			listSt = query.list();
			session.getTransaction().commit();//Đầy Object lên DB
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("getListKhachHang-err: " + e.toString());
		}finally {
			session.close();
			//Đóng tài nguyên sessionFactory (gồm Session, connection DB,..)
			//sessionFactory.close();
		}
		
		return listSt;
	}
	
}
