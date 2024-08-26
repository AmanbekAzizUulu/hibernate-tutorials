package hibernate_tutorial;

import org.hibernate.Session;

import hibernate_tutorial.dto.Student;
import hibernate_tutorial.dto.dto_utils.DateOfBirth;
import hibernate_tutorial.util.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Student student = new Student("Datkayim", "Sabyrbekova",  new DateOfBirth(1998, 10, 14));
		System.out.println(student);

		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
	}
}
