package com.example.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "DuyAn_Client_addresses")
public class ClientAddresses implements java.io.Serializable {

	private int clientId;
	private Address address;
	private Clients clients;
	private String dateAddressFrom;
	private String dateAddressTo;

	public ClientAddresses() {
	}

	public ClientAddresses(Address address, Clients clients, String dateAddressFrom, String dateAddressTo) {
		this.address = address;
		this.clients = clients;
		this.dateAddressFrom = dateAddressFrom;
		this.dateAddressTo = dateAddressTo;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "clients"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "client_id", unique = true, nullable = false)
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Clients getClients() {
		return this.clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	@Column(name = "date_address_from", nullable = false, length = 50)
	public String getDateAddressFrom() {
		return this.dateAddressFrom;
	}

	public void setDateAddressFrom(String dateAddressFrom) {
		this.dateAddressFrom = dateAddressFrom;
	}

	@Column(name = "date_address_to", nullable = false, length = 50)
	public String getDateAddressTo() {
		return this.dateAddressTo;
	}

	public void setDateAddressTo(String dateAddressTo) {
		this.dateAddressTo = dateAddressTo;
	}

}
