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
@Table(name = "DuyAn_Ref_Curencies")
public class RefCurencies implements java.io.Serializable {

	private String currencyCode;
	private String currencyName;
	private String nominalEchangeRate;
	private Set<Clients> clientses = new HashSet<Clients>(0);

	public RefCurencies() {
	}

	public RefCurencies(String currencyCode, String currencyName, String nominalEchangeRate) {
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.nominalEchangeRate = nominalEchangeRate;
	}

	public RefCurencies(String currencyCode, String currencyName, String nominalEchangeRate, Set<Clients> clientses) {
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.nominalEchangeRate = nominalEchangeRate;
		this.clientses = clientses;
	}

	@Id

	@Column(name = "currency_code", unique = true, nullable = false, length = 50)
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name = "currency_name", nullable = false, length = 50)
	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Column(name = "nominal_echange_rate", nullable = false, length = 50)
	public String getNominalEchangeRate() {
		return this.nominalEchangeRate;
	}

	public void setNominalEchangeRate(String nominalEchangeRate) {
		this.nominalEchangeRate = nominalEchangeRate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refCurencies")
	public Set<Clients> getClientses() {
		return this.clientses;
	}

	public void setClientses(Set<Clients> clientses) {
		this.clientses = clientses;
	}

}
