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





@Controller
@RequestMapping("/admin")
public class AdminController {
	
	 @Autowired
	 GymService gymService;
	

	 @GetMapping("/")
		public String index(ModelMap model) {
		    return "/admin/index";
		}
	 
	 
	 @GetMapping("/monitors")
		public String viewMonitors(ModelMap model) {
		   List<Monitor> list = new ArrayList<Monitor>(gymService.getMonitors().values());

		   model.addAttribute("list", list); 
			
		   return "/admin/monitors";
	 }
	 
	 
	 @GetMapping("/activities")
		public String viewActivities(ModelMap model) {
		 List<Activity> list = new ArrayList<Activity>(gymService.getActivities().values());

		   model.addAttribute("list", list); 
		    return "/admin/activities";
		}
	 
	 @GetMapping("/activities/{id}/edit")
		public String editActivities(@PathVariable long id, ModelMap model) {
		 Activity activity = gymService.getActivities().get(id);

		   model.addAttribute("activity", activity); 
		    return "/admin/activities_edit";
		}
	 
	 @PutMapping("/activities/{id}/edit")
		public ResponseEntity<Activity> editActivitiesSubmit(@RequestBody Activity activity, @PathVariable long id) {
		 	Activity oldActivity = gymService.getActivities().get(id);
			if (oldActivity != null) {
				activity.setId(id);
				gymService.getActivities().put(id, activity);
				return new ResponseEntity<>(activity, HttpStatus.OK);

			} 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);



		}
	 
	 
	 @GetMapping("/customers")
		public String viewCustomers(ModelMap model) {
		 List<Customer> list = new ArrayList<Customer>(gymService.getCustomers().values());

		   model.addAttribute("list", list); 
		    return "/admin/customers";
		}
	 
	 @PostMapping("/activities/add")
	 @ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Activity> createItem(@RequestBody Activity activity) {
			//a
			gymService.addActivity(activity);
			 return new ResponseEntity<>(activity, HttpStatus.OK);
		}
	 @DeleteMapping("/activities/{id}/remove")
	 public ResponseEntity<Activity> deleteItem(@PathVariable long id) {
	 
		 gymService.getActivities().remove(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	
	 }
	 
	 
	
}