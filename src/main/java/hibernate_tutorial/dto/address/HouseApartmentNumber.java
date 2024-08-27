package hibernate_tutorial.dto.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HouseApartmentNumber {
	@Column(name = "house_number", nullable = false)
	private int houseNumber;
	@Column(name = "apartment_number", nullable = false)
	private int apartmentNumber;

	public HouseApartmentNumber() {
	}

	public HouseApartmentNumber(int houseNumber, int apartmentNumber) {
		this.houseNumber = houseNumber;
		this.apartmentNumber = apartmentNumber;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

}
