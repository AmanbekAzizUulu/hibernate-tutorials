package hibernate_tutorial.dto.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "streets")
public class Street {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "street_id", nullable = false)
	private Long streetId;

	@Column(name = "street_name", nullable = false)
	private String name;

	@Embedded
	private HouseApartmentNumber houseApartmentNumber;

	public Street() {
	}

	public Street(String name, HouseApartmentNumber houseApartmentNumber) {
		this.name = name;
		this.houseApartmentNumber = houseApartmentNumber;
	}

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HouseApartmentNumber getHouseApartmentNumber() {
		return houseApartmentNumber;
	}

	public void setHouseApartmentNumber(HouseApartmentNumber houseApartmentNumber) {
		this.houseApartmentNumber = houseApartmentNumber;
	}
}
