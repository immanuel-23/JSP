package com.aurionpro.model;

public class Admin {
	private int adminId;
	private String adminUname;
	private String adminPass;

	public Admin(int adminId, String adminUname, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminUname = adminUname;
		this.adminPass = adminPass;
	}

	public Admin(String adminUname, String adminPass) {
		super();

		this.adminUname = adminUname;
		this.adminPass = adminPass;
	}

	public int getAdminId() {
		return adminId;
	}

	public String getAdminUname() {
		return adminUname;
	}

	public String getAdminPass() {
		return adminPass;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUname=" + adminUname + ", adminPass=" + adminPass + "]";
	}

}