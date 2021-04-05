package com.example.Gym;



//Crearnos una cuenta de github e ir subiendo la mierda de codigo, para que el nico este feliz. 
// Login
// Propagar de actividades a clientes y monitores en panel de adminstrador
// Que los clientes puedan cambiar sus datos
// Que un usuario se pueda inscribir en una clase
// Que un administrador pueda controlar las inscripiones de los usuarios de las clases
// Paginas de error
// Hacer un footer en condiciones
// Comentarios de todo
// Filtros de busqueda para la api rest
// Guion de la presentacion
// Presentacion de postman

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiRestController {
	 
	@Autowired
	GymService gymService;
	
	@GetMapping("/activities") 
	public Collection<Activity> getActivities() {
		return gymService.getActivities().values();
	}
	
	@GetMapping("/activity/{id}") 
	public ResponseEntity<Activity> getActivity(@PathVariable long id) {
		return new ResponseEntity<>(gymService.getActivities().get(id), HttpStatus.OK);
	}
	
	@PutMapping("/activity/{id}/edit")
	public ResponseEntity<Activity> editActivities(@RequestBody Activity activity, @PathVariable long id) {
	 	Activity oldActivity = gymService.getActivities().get(id);
		if (oldActivity != null) {
			activity.setId(id);
			gymService.getActivities().put(id, activity);
			return new ResponseEntity<>(activity, HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/activity/{id}/remove")
	 public ResponseEntity<Activity> deleteItem(@PathVariable long id) {
		 gymService.getActivities().remove(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	
	
	
	
	
	
	@GetMapping("/monitors") 
	public Collection<Monitor> getMonitors() {
		return gymService.getMonitors().values();
	}
	@GetMapping("/monitor/{id}") 
	public ResponseEntity<Monitor> getMonitor(@PathVariable long id) {
		return new ResponseEntity<>(gymService.getMonitors().get(id), HttpStatus.OK);
	}
	
	@PutMapping("/monitor/{id}/edit")
	public ResponseEntity<Monitor> editMonitor(@RequestBody Monitor monitor, @PathVariable long id) {
	 	Monitor oldMonitor = gymService.getMonitors().get(id);
		if (oldMonitor != null) {
			monitor.setId(id);
			gymService.getMonitors().put(id, monitor);
			return new ResponseEntity<>(monitor, HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/monitor/{id}/remove")
	 public ResponseEntity<Activity> deleteMonitor(@PathVariable long id) {
		 gymService.getMonitors().remove(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	
	
	
	
	
	
	@GetMapping("/customers") 
	public Collection<Customer> getCustomers() {
		return gymService.getCustomers().values();
	}
	
	@GetMapping("/customers/{id}") 
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		return new ResponseEntity<>(gymService.getCustomers().get(id), HttpStatus.OK);
	}
	
	@PutMapping("/customer/{id}/edit")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer, @PathVariable long id) {
	 	Customer oldCustomer = gymService.getCustomers().get(id);
		if (oldCustomer != null) {
			customer.setId(id);
			gymService.getCustomers().put(id, customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/customer/{id}/remove")
	 public ResponseEntity<Activity> deleteCustomer(@PathVariable long id) {
		 gymService.getCustomers().remove(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	
	
}