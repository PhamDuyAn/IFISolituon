package com.example.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DuyAn_Address")
public class Address implements java.io.Serializable {

	private int addressId;
	private String line1NumberBuilding;
	private String line2NumberStreet;
	private String line3AreaLocality;
	private String townCity;
	private String stateProvince;
	private int countryCode;
	private Set<ClientAddresses> clientAddresseses = new HashSet<ClientAddresses>(0);

	public Address() {
	}

	public Address(int addressId, String line1NumberBuilding, String line2NumberStreet, String line3AreaLocality,
			String townCity, String stateProvince, int countryCode) {
		this.addressId = addressId;
		this.line1NumberBuilding = line1NumberBuilding;
		this.line2NumberStreet = line2NumberStreet;
		this.line3AreaLocality = line3AreaLocality;
		this.townCity = townCity;
		this.stateProvince = stateProvince;
		this.countryCode = countryCode;
	}

	public Address(int addressId, String line1NumberBuilding, String line2NumberStreet, String line3AreaLocality,
			String townCity, String stateProvince, int countryCode, Set<ClientAddresses> clientAddresseses) {
		this.addressId = addressId;
		this.line1NumberBuilding = line1NumberBuilding;
		this.line2NumberStreet = line2NumberStreet;
		this.line3AreaLocality = line3AreaLocality;
		this.townCity = townCity;
		this.stateProvince = stateProvince;
		this.countryCode = countryCode;
		this.clientAddresseses = clientAddresseses;
	}

	@Id

	@Column(name = "address_id", unique = true, nullable = false)
	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "line_1_number_building", nullable = false, length = 50)
	public String getLine1NumberBuilding() {
		return this.line1NumberBuilding;
	}

	public void setLine1NumberBuilding(String line1NumberBuilding) {
		this.line1NumberBuilding = line1NumberBuilding;
	}

	@Column(name = "line_2_number_street", nullable = false, length = 50)
	public String getLine2NumberStreet() {
		return this.line2NumberStreet;
	}

	public void setLine2NumberStreet(String line2NumberStreet) {
		this.line2NumberStreet = line2NumberStreet;
	}

	@Column(name = "line_3_area_locality", nullable = false, length = 50)
	public String getLine3AreaLocality() {
		return this.line3AreaLocality;
	}

	public void setLine3AreaLocality(String line3AreaLocality) {
		this.line3AreaLocality = line3AreaLocality;
	}

	@Column(name = "town_city", nullable = false, length = 50)
	public String getTownCity() {
		return this.townCity;
	}

	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}

	@Column(name = "state_province", nullable = false, length = 50)
	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@Column(name = "country_code", nullable = false)
	public int getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<ClientAddresses> getClientAddresseses() {
		return this.clientAddresseses;
	}

	public void setClientAddresseses(Set<ClientAddresses> clientAddresseses) {
		this.clientAddresseses = clientAddresseses;
	}

}
