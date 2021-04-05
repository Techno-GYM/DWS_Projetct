package com.example.Gym;

import java.util.Set;

public class Admin {
	
	private long idAdmin = -1;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;
	private Set<Customer> customers;

	public Admin() {
		
	}
	
	public long getIdAdmin() {
		return idAdmin;
	}
	
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
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
	
	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setActivity(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeActivity(Customer customer) {
		this.customers.remove(customer);
	}
	
	public Set<Customer> getActivities() {
		return this.customers;
	}


























}