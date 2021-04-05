package com.example.Gym;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Activity {
	
	private long idActivity = -1;
	private String name;
	private String description;
	private String img;
	private String beginning;
	private String end;
    private List<Customer> customers;

	public Activity() {
		this.customers = new ArrayList<>();
	}
	
	public long getId() {
		return idActivity;
	}
	
	public void setId(long idActivity) {
		this.idActivity = idActivity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg (String img) {
		this.img = img;
	}

	public String getBeginning() {
		return beginning;
	}

	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
	public void setCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		this.customers.remove(customer);
	}
	
	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	
}











