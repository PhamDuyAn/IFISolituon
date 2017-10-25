package com.example.Entity;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ServicesOnProjectsId implements java.io.Serializable {

	private String serviceCode;
	private int projectId;

	public ServicesOnProjectsId() {
	}

	public ServicesOnProjectsId(String serviceCode, int projectId) {
		this.serviceCode = serviceCode;
		this.projectId = projectId;
	}

	@Column(name = "service_code", nullable = false, length = 50)
	public String getServiceCode() {
		return this.serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Column(name = "project_id", nullable = false)
	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ServicesOnProjectsId))
			return false;
		ServicesOnProjectsId castOther = (ServicesOnProjectsId) other;

		return ((this.getServiceCode() == castOther.getServiceCode()) || (this.getServiceCode() != null
				&& castOther.getServiceCode() != null && this.getServiceCode().equals(castOther.getServiceCode())))
				&& (this.getProjectId() == castOther.getProjectId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getServiceCode() == null ? 0 : this.getServiceCode().hashCode());
		result = 37 * result + this.getProjectId();
		return result;
	}

}
