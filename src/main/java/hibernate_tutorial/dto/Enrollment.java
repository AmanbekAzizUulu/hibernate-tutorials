package hibernate_tutorial.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import hibernate_tutorial.dto.dto_utils.DateOfEnrollmentRegistration;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
@Entity
@Table (name="enrollments")
public class Enrollment {
	@EmbeddedId
	private EnrollmentId enrollmentId;

	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course course;

	@Column(name = "enrollment_date", nullable = false)
	private LocalDate enrollmentDate;


	public Enrollment(DateOfEnrollmentRegistration enrollmentDate, Student student, Course course) {
		this.enrollmentDate = LocalDate.of(enrollmentDate.getYear(), enrollmentDate.getMonth() , enrollmentDate.getDay());
		this.student = student;
		this.course = course;
		this.enrollmentId = new EnrollmentId(student.getId(), course.getCourseId());
	}

	public EnrollmentId getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(EnrollmentId enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Embeddable
	private class EnrollmentId implements Serializable {
		@Column(name = "student_id", nullable = false)
		private Long studentId;

		@Column(name="course_id", nullable = false)
		private Long courseId;

		protected EnrollmentId(Long studentId, Long courseId) {
			this.studentId = studentId;
			this.courseId = courseId;
		}

		protected Long getStudentId() {
			return studentId;
		}

		protected void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		protected Long getCourseId() {
			return courseId;
		}

		protected void setCourseId(Long courseId) {
			this.courseId = courseId;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;  // Проверка, указывают ли ссылки на один и тот же объект
			if (o == null || getClass() != o.getClass()) return false;  // Проверка на null и соответствие классов

			EnrollmentId that = (EnrollmentId) o;  // Приведение объекта к нужному типу

			// Сравнение значений полей
			return Objects.equals(studentId, that.studentId) &&
				   Objects.equals(courseId, that.courseId);
		}

		@Override
		public int hashCode() {
			// Возвращаем хэш-код, сгенерированный на основе значений полей
			return Objects.hash(studentId, courseId);
		}




	}
}
