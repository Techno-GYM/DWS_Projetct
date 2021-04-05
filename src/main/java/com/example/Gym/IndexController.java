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
public class IndexController {
	
	 @Autowired
	 GymService gymService;
	
	
	 
	 
	 
	@GetMapping("/")
	public String  index(ModelMap model) {
		
		List<Activity> list = new ArrayList<Activity>(gymService.getActivities().values());

		model.addAttribute("activities", list); 
		
	    return "index";
	}
	
	@GetMapping("/join/{id}")
	public String  joinActivity(ModelMap model) {
		List<Activity> list = new ArrayList<Activity>(gymService.getActivities().values());
		model.addAttribute("activities", list); 
	    return "index";
	}
	
	
	@GetMapping("/activity/{id}")
	public String viewActivity(ModelMap model, @PathVariable long id) {
		
		Activity activity = gymService.getActivities().get(id);

		model.addAttribute("activity", activity); 
		
	    return "activity";
	}
	
	
	
	
	
	
	@GetMapping("/load")
	public String load() {
	 
		 Activity activity_1 = CreateActivityTemporalWithoutDatabase("Yoga", "15:00", "17:00", "https://www.webconsultas.com/sites/default/files/styles/wc_adaptive_image__small/public/temas/yoga.jpg", "El yoga es la unión de mente, cuerpo y alma, la búsqueda del Samadhi, encontrar la felicidad");
		 Activity activity_2 = CreateActivityTemporalWithoutDatabase("Boxeo", "17:30", "19:00", "https://www.mundodeportivo.com/r/GODO/MD/p8/Polideportivo/Imagenes/2021/02/27/Recortada/20210228-637500866695183239_20210228053002-kRx-U492320340635s8C-980x554@MundoDeportivo-Web.jpg", "El boxeo es un deporte de contacto en el que dos contrincantes luchan utilizando únicamente sus puños");
		 Activity activity_3 = CreateActivityTemporalWithoutDatabase("Zumba", "19:15", "20:00", "https://mejorconsalud.as.com/fitness/wp-content/uploads/2018/03/zumba-canciones-bailar-coreografia.jpg", "Zumba es una disciplina fitness creada a mediados de los años 1990 por el colombiano Alberto \"Beto\" Pérez, ​ enfocada por una parte a mantener un cuerpo saludable y por otra a desarrollar, fortalecer y dar flexibilidad al cuerpo mediante movimientos de baile combinados con una serie de rutinas aeróbicas.");
	     Customer customer_1 = CreateCustomer("Sergio", "sergio@gmail.com", "Calle de la prueba 13", "6723485627", "123123123");
	     Monitor monitor_1 = CreateMonitor("Monito1", "monitor1@gmail.com", "Calle de la prueba 1", "682662819", "123123123");
	     monitor_1.setActivity(activity_1);
	     monitor_1.setActivity(activity_2);
	     monitor_1.setActivity(activity_3);
	     activity_1.setCustomer(customer_1);
	     
	     
		 return "redirect:/";

	}


	
	public Activity CreateActivityTemporalWithoutDatabase(String name, String h_begin, String h_end, String img, String description) {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setBeginning(h_begin);
		activity.setEnd(h_end);
		activity.setImg(img);
		activity.setDescription(description);
		gymService.addActivity(activity);
		return activity;

	}
	
	public Customer CreateCustomer(String name, String email, String address, String phone, String password) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setPassword(password);
		gymService.addCustomer(customer);
		return customer;

	}
	
	
	public Monitor CreateMonitor(String name, String email, String address, String phone, String password) {
		Monitor monitor = new Monitor();
		monitor.setName(name);
		monitor.setEmail(email);
		monitor.setAddress(address);
		monitor.setPhone(phone);
		monitor.setPassword(password);
		gymService.addMonitor(monitor);
		return monitor;

	}
	
}