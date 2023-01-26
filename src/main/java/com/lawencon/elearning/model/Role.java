package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role extends BaseModel {

	@Column(name = "role_code", unique = true, nullable = false, length = 5)
	private String roleCode;
	
	@Column(name = "role_name", nullable = false, length = 20)
	private String roleName;


	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
