package com.example.Gym;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Monitor {
	
	private long idMonitor = -1;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;
	private List<Activity> activities;
	
	public Monitor() {
		this.activities = new ArrayList<>();

	}
	
	public long getId() {
		return idMonitor;
	}
	
	public void setId(long idMonitor) {
		this.idMonitor = idMonitor;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setActivity(Activity activity) {
		this.activities.add(activity);
	}
	
	public void removeActivity(Activity activity) {
		this.activities.remove(activity);
	}
	
	public List<Activity> getActivities() {
		return this.activities;
	}
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}











