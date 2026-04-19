package com.rays.jdbc;

public class WatchBean {
	private int id;
	private String deviceName;
	private int heartRate;
	private int  stepsCount;
	private double caloriesBurned;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public int getStepsCount() {
		return stepsCount;
	}
	public void setStepsCount(int stepsCount) {
		this.stepsCount = stepsCount;
	}
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	

}
