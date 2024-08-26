package hibernate_tutorial;

import org.hibernate.Session;

import hibernate_tutorial.dto.Student;
import hibernate_tutorial.util.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		Student student = new Student();
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		student = session.get(Student.class, 1);

		System.out.println("Retrieved object: ");
		System.out.println(student);
		
	}
}
