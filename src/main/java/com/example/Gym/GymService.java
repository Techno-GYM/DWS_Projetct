package com.example.Gym;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Service
public class GymService {

	
	public Map<Long, Activity> list_activities = new ConcurrentHashMap<>();
	
	public Map<Long, Monitor> list_monitors = new ConcurrentHashMap<>();
	
	public Map<Long, Customer> list_customers = new ConcurrentHashMap<>();
	
	private AtomicLong lastId = new AtomicLong();
	
	public void addActivity(Activity activity)
	{
		Long id = lastId.getAndIncrement();
		activity.setId(id);
		list_activities.put(id, activity);
	}
	
	public void removeActivity(Activity activity)
	{
		//list_activities.remove(activity);
	}
	
	public Map<Long, Activity> getActivities()
	{
		return list_activities;
	}
	
	
	
	public void addMonitor(Monitor monitor)
	{
		Long id = lastId.getAndIncrement();
		monitor.setId(id);
		list_monitors.put(id, monitor);
	}
	
	public void removeMonitor(Monitor monitor)
	{
		list_monitors.remove(monitor);
	}
	
	public Map<Long, Monitor> getMonitors()
	{
		return list_monitors;
	}
	
	
	
	public void addCustomer(Customer customer)
	{
		Long id = lastId.getAndIncrement();
		customer.setId(id);
		list_customers.put(id, customer);
	}
	
	public void removeCustomer(Customer customer)
	{
		//list_customers.remove(customer);
	}
	
	public Map<Long, Customer> getCustomers()
	{
		return list_customers;
	}
	
}