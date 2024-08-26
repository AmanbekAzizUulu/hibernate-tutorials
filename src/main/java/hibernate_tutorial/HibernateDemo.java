package hibernate_tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_tutorial.dto.User;

public class HibernateDemo {
	public static void main(String[] args) {
		User user = new User(  "Aiturgan", "Karabalaeva");

		System.out.println(user);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
}
