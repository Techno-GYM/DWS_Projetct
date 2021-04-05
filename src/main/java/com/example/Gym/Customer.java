package com.example.Gym;

import java.util.Set;

public class Customer {
	
	private long idCustomer = -1;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;
    private Set<Activity> activities;

	public Customer() {
		
	}
	
	public long getId() {
		return this.idCustomer;
	}
	
	public void setId(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void setActivity(Activity activity) {
		this.activities.add(activity);
	}
	
	public void removeActivity(Activity activity) {
		this.activities.remove(activity);
	}
	
	public Set<Activity> getActivities() {
		return this.activities;
	}

}











