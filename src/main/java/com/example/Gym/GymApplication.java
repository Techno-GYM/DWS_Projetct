package com.example.Gym;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.samskivert.mustache.Mustache;

@SpringBootApplication
public class GymApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}
	
	 @Bean
	    public Mustache.Compiler mustacheCompiler(
	            Mustache.TemplateLoader templateLoader,
	            Environment environment) {
	 
	        MustacheEnvironmentCollector collector
	                = new MustacheEnvironmentCollector();
	        collector.setEnvironment(environment);
	 
	        return Mustache.compiler()
	                .defaultValue("Some Default Value")
	                .withLoader(templateLoader)
	                .withCollector(collector);
	    }

}
