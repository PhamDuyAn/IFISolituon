package com.example.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clients generated by hbm2java
 */
@Entity
@Table(name = "DuyAn_Clients")
public class Clients implements java.io.Serializable {

	private int clientId;
	private RefCurencies refCurencies;
	private String clientName;
	private String clientFromDate;
	private String kpiAvgBillableRate;
	private String kpiBillingsToDate;
	private String kpiClientProjectCount;
	private String otherClientDetails;
	private Set<Projects> projectses = new HashSet<Projects>(0);
	private ClientAddresses clientAddresses;

	public Clients() {
	}

	public Clients(int clientId, RefCurencies refCurencies, String clientName, String clientFromDate,
			String kpiAvgBillableRate, String kpiBillingsToDate, String kpiClientProjectCount,
			String otherClientDetails) {
		this.clientId = clientId;
		this.refCurencies = refCurencies;
		this.clientName = clientName;
		this.clientFromDate = clientFromDate;
		this.kpiAvgBillableRate = kpiAvgBillableRate;
		this.kpiBillingsToDate = kpiBillingsToDate;
		this.kpiClientProjectCount = kpiClientProjectCount;
		this.otherClientDetails = otherClientDetails;
	}

	public Clients(int clientId, RefCurencies refCurencies, String clientName, String clientFromDate,
			String kpiAvgBillableRate, String kpiBillingsToDate, String kpiClientProjectCount,
			String otherClientDetails, Set<Projects> projectses, ClientAddresses clientAddresses) {
		this.clientId = clientId;
		this.refCurencies = refCurencies;
		this.clientName = clientName;
		this.clientFromDate = clientFromDate;
		this.kpiAvgBillableRate = kpiAvgBillableRate;
		this.kpiBillingsToDate = kpiBillingsToDate;
		this.kpiClientProjectCount = kpiClientProjectCount;
		this.otherClientDetails = otherClientDetails;
		this.projectses = projectses;
		this.clientAddresses = clientAddresses;
	}

	@Id

	@Column(name = "client_id", unique = true, nullable = false)
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_code", nullable = false)
	public RefCurencies getRefCurencies() {
		return this.refCurencies;
	}

	public void setRefCurencies(RefCurencies refCurencies) {
		this.refCurencies = refCurencies;
	}

	@Column(name = "client_name", nullable = false, length = 100)
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "client_from_date", nullable = false, length = 20)
	public String getClientFromDate() {
		return this.clientFromDate;
	}

	public void setClientFromDate(String clientFromDate) {
		this.clientFromDate = clientFromDate;
	}

	@Column(name = "kpi_avg_billable_rate", nullable = false, length = 50)
	public String getKpiAvgBillableRate() {
		return this.kpiAvgBillableRate;
	}

	public void setKpiAvgBillableRate(String kpiAvgBillableRate) {
		this.kpiAvgBillableRate = kpiAvgBillableRate;
	}

	@Column(name = "kpi_billings_to_date", nullable = false, length = 50)
	public String getKpiBillingsToDate() {
		return this.kpiBillingsToDate;
	}

	public void setKpiBillingsToDate(String kpiBillingsToDate) {
		this.kpiBillingsToDate = kpiBillingsToDate;
	}

	@Column(name = "kpi_client_project_count", nullable = false, length = 50)
	public String getKpiClientProjectCount() {
		return this.kpiClientProjectCount;
	}

	public void setKpiClientProjectCount(String kpiClientProjectCount) {
		this.kpiClientProjectCount = kpiClientProjectCount;
	}

	@Column(name = "other_client_details", nullable = false, length = 250)
	public String getOtherClientDetails() {
		return this.otherClientDetails;
	}

	public void setOtherClientDetails(String otherClientDetails) {
		this.otherClientDetails = otherClientDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	public Set<Projects> getProjectses() {
		return this.projectses;
	}

	public void setProjectses(Set<Projects> projectses) {
		this.projectses = projectses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "clients")
	public ClientAddresses getClientAddresses() {
		return this.clientAddresses;
	}

	public void setClientAddresses(ClientAddresses clientAddresses) {
		this.clientAddresses = clientAddresses;
	}

}
