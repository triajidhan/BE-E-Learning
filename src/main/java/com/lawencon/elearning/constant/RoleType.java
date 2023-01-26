package com.lawencon.elearning.constant;

public enum RoleType {
	STUDENT("Siswa", "STD"),
	TEACHER("Pengajar", "TCH"),
	SUPER_ADMIN("Super Admin", "SAD"),
	SYSTEM("System", "SYS");
	
	private String roleName;
	private String roleCode;
	
	private RoleType(String roleName, String roleCode) {
		this.roleName = roleName;
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}	
}

