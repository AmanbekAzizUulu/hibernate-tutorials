package hibernate_tutorial;

import org.hibernate.Session;

import hibernate_tutorial.dto.Course;
import hibernate_tutorial.dto.Enrollment;
import hibernate_tutorial.dto.Student;
import hibernate_tutorial.dto.dto_utils.DateOfBirth;
import hibernate_tutorial.dto.dto_utils.DateOfEnrollmentRegistration;
import hibernate_tutorial.util.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		// Открытие сессии
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Создание объектов
		Course course = new Course("General histology");
		Student student = new Student("Munarbek", "Turarov", new DateOfBirth(1999, 1, 23));
		Enrollment enrollment = new Enrollment(new DateOfEnrollmentRegistration(2024, 8, 17), student, course);

		session.beginTransaction();

		session.persist(student);
		session.persist(course);
		session.persist(enrollment);

		session.getTransaction().commit();
		session.close();
	}
}
