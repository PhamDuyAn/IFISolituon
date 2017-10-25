package com.example.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Staff generated by hbm2java
 */
@Table(value = "staff")
public class Staff implements java.io.Serializable {

	@PrimaryKey
	private Integer staff_id;
	
	private String staff_name;
	private String gender_MF;
	private String date_of_birth;
	private String daily_cost;
	private String daily_rate;
	private String date_joined;
	private String date_left;
	private String other_staff_details;
	//private Set<StaffOnProjects> staffOnProjectses = new HashSet<StaffOnProjects>(0);
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getGender_MF() {
		return gender_MF;
	}
	public void setGender_MF(String gender_MF) {
		this.gender_MF = gender_MF;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getDaily_cost() {
		return daily_cost;
	}
	public void setDaily_cost(String daily_cost) {
		this.daily_cost = daily_cost;
	}
	public String getDaily_rate() {
		return daily_rate;
	}
	public void setDaily_rate(String daily_rate) {
		this.daily_rate = daily_rate;
	}
	public String getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(String date_joined) {
		this.date_joined = date_joined;
	}
	public String getDate_left() {
		return date_left;
	}
	public void setDate_left(String date_left) {
		this.date_left = date_left;
	}
	public String getOther_staff_details() {
		return other_staff_details;
	}
	public void setOther_staff_details(String other_staff_details) {
		this.other_staff_details = other_staff_details;
	}
	public Staff(Integer staff_id, String staff_name, String gender_MF, String date_of_birth, String daily_cost,
			String daily_rate, String date_joined, String date_left, String other_staff_details) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.gender_MF = gender_MF;
		this.date_of_birth = date_of_birth;
		this.daily_cost = daily_cost;
		this.daily_rate = daily_rate;
		this.date_joined = date_joined;
		this.date_left = date_left;
		this.other_staff_details = other_staff_details;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}