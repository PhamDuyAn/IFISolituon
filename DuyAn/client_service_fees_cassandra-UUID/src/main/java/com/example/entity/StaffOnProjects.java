package com.example.entity;
// Generated Sep 27, 2017 11:56:10 AM by Hibernate Tools 5.2.5.Final

import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * StaffOnProjects generated by hbm2java
 */

@Table(value = "staff_on_projects")
public class StaffOnProjects implements java.io.Serializable {

	
	@PrimaryKey
	private UUID staff_on_project_perioc_id;
	private UUID project_id;
	private UUID staff_id;
	private String role_code;
	@Override
	public String toString() {
		return "StaffOnProjects [staff_on_project_perioc_id=" + staff_on_project_perioc_id + ", project_id="
				+ project_id + ", staff_id=" + staff_id + ", role_code=" + role_code + ", from_datetime="
				+ from_datetime + ", to_datetime=" + to_datetime + ", hourty_rate=" + hourty_rate + "]";
	}

	private String from_datetime;
	private String to_datetime;
	private String hourty_rate;

	public StaffOnProjects() {
		staff_on_project_perioc_id = UUID.randomUUID();
	}
	
	@Column("staff_on_project_perioc_id")
	public UUID getStaffOnProjectPeriocId() {
		return staff_on_project_perioc_id;
	}

	public void setStaffOnProjectPeriocId(UUID staffOnProjectPeriocId) {
		this.staff_on_project_perioc_id = staffOnProjectPeriocId;
	}

	@Column("project_id")
	public UUID getProjectsid() {
		return project_id;
	}

	public void setProjectsid(UUID projectsid) {
		this.project_id = projectsid;
	}

	@Column("staff_id")
	public UUID getStaffid() {
		return staff_id;
	}

	public void setStaffid(UUID staffid) {
		this.staff_id = staffid;
	}

	@Column("role_code")
	public String getRefRolescode() {
		return role_code;
	}

	public void setRefRolescode(String refRolescode) {
		this.role_code = refRolescode;
	}

	@Column("from_datetime")
	public String getFromDatetime() {
		return from_datetime;
	}

	public void setFromDatetime(String fromDatetime) {
		this.from_datetime = fromDatetime;
	}

	@Column("to_datetime")
	public String getToDatetime() {
		return to_datetime;
	}

	public void setToDatetime(String toDatetime) {
		this.to_datetime = toDatetime;
	}

	@Column("hourty_rate")
	public String getHourtyRate() {
		return hourty_rate;
	}

	public void setHourtyRate(String hourtyRate) {
		this.hourty_rate = hourtyRate;
	}

	public StaffOnProjects( UUID projectsid, UUID staffid, String refRolescode,
			String fromDatetime, String toDatetime, String hourtyRate) {
		super();
		this.project_id = projectsid;
		this.staff_id = staffid;
		this.role_code = refRolescode;
		this.from_datetime = fromDatetime;
		this.to_datetime = toDatetime;
		this.hourty_rate = hourtyRate;
	}

	

}
