package hibernate_tutorial.dto.dto_utils;

public class DateOfEnrollmentRegistration {
	private final int year;
	private final int month;
	private final int day;

	public DateOfEnrollmentRegistration(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

}
