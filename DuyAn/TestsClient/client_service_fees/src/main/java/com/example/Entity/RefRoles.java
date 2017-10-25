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
@Table(name = "DuyAn_Ref_Roles")
public class RefRoles implements java.io.Serializable {

	private String roleCode;
	private String roleName;
	private String egProjectManager;
	private Set<StaffOnProjects> staffOnProjectses = new HashSet<StaffOnProjects>(0);

	public RefRoles() {
	}

	public RefRoles(String roleCode, String roleName, String egProjectManager) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.egProjectManager = egProjectManager;
	}

	public RefRoles(String roleCode, String roleName, String egProjectManager, Set<StaffOnProjects> staffOnProjectses) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.egProjectManager = egProjectManager;
		this.staffOnProjectses = staffOnProjectses;
	}

	@Id

	@Column(name = "role_code", unique = true, nullable = false, length = 50)
	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Column(name = "role_name", nullable = false, length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "eg_Project_Manager", nullable = false, length = 50)
	public String getEgProjectManager() {
		return this.egProjectManager;
	}

	public void setEgProjectManager(String egProjectManager) {
		this.egProjectManager = egProjectManager;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refRoles")
	public Set<StaffOnProjects> getStaffOnProjectses() {
		return this.staffOnProjectses;
	}

	public void setStaffOnProjectses(Set<StaffOnProjects> staffOnProjectses) {
		this.staffOnProjectses = staffOnProjectses;
	}

}
