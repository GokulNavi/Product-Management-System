package com.example.jsp.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jsp.demo.model.Product;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		//Product product=new Product();
//		Product product=null;
//		Optional.of(product)
//		.map(p->{System.out.println("Inside Map");
//		return p;
//		})
//		.orElseThrow(()->new RuntimeException());
	}

}
