package hibernate_tutorial;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate_tutorial.dto.Department;
import hibernate_tutorial.dto.Employee;
import hibernate_tutorial.util.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Department department = new Department("Support", null);

		Employee employee_1 = new Employee("Nurbek", "Turanov", null);
		Employee employee_2 = new Employee("Diyor", "Musaev", null);
		Employee employee_3 = new Employee("Aibek", "Aidar uulu", null);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee_1);
		employees.add(employee_2);
		employees.add(employee_3);

		department.setEmployees(employees);


		session.beginTransaction();
		session.persist(department);
		session.getTransaction().commit();

		employee_1.setDepartment(department);
		employee_2.setDepartment(department);
		employee_3.setDepartment(department);

		session.beginTransaction();
		session.persist(employee_1);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(employee_2);
		session.getTransaction().commit();

		session.beginTransaction();
		session.persist(employee_3);
		session.getTransaction().commit();

		session.close();
	}
}
