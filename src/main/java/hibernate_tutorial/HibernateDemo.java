package hibernate_tutorial;

import org.hibernate.Session;

import hibernate_tutorial.dto.Student;
import hibernate_tutorial.dto.address.Address;
import hibernate_tutorial.dto.address.City;
import hibernate_tutorial.dto.address.HouseApartmentNumber;
import hibernate_tutorial.dto.address.Region;
import hibernate_tutorial.dto.address.Street;
import hibernate_tutorial.dto.dto_utils.DateOfBirth;
import hibernate_tutorial.util.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		City city = new City("Bishkek", "720076");
		Region region = new Region("Chui");
		Street street = new Street("Dobrovol'skogo", new HouseApartmentNumber(15, 2));
		Address address = new Address(city, region, street);
		Student student = new Student("Amanbek", "Jumakanov", new DateOfBirth(1998, 10, 20), address);

		session.beginTransaction();
		session.persist(city);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(region);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(street);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(address);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
	}
}
