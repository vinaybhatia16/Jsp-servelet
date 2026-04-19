package com.rays.jdbc;

public class BuildBean {

	private long buildId;

	private String buildCode;

	private String buildVersion;

	private String triggeredBy;

	public long getBuildId() {
		return buildId;
	}

	public void setBuildId(long buildId) {
		this.buildId = buildId;
	}

	public String getBuildCode() {
		return buildCode;
	}

	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getTriggeredBy() {
		return triggeredBy;
	}

	public void setTriggeredBy(String triggeredBy) {
		this.triggeredBy = triggeredBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

}
