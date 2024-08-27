package hibernate_tutorial.dto.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	private Long addressId;

	@ManyToOne
    @JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
    @JoinColumn(name = "region_id")
	private Region region;

	@ManyToOne
    @JoinColumn(name = "street_id")
	private Street street;


	public Address(){
	}

	public Address(City city, Region region, Street street) {
		this.city = city;
		this.region = region;
		this.street = street;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}


}
