package com.rays.jdbc;

public class DashboardBean {

	private int dashboardid;

	public int getDashboardid() {
		return dashboardid;
	}

	public void setDashboardid(int dashboardid) {
		this.dashboardid = dashboardid;
	}

	public String getDashboardcode() {
		return dashboardcode;
	}

	public void setDashboardcode(String dashboardcode) {
		this.dashboardcode = dashboardcode;
	}

	public String getDashboardname() {
		return dashboardname;
	}

	public void setDashboardname(String dashboardname) {
		this.dashboardname = dashboardname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String dashboardcode;

	private String dashboardname;

	private String username;

	private String status;

}
