package com.example.jsp.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jsp.demo.model.Product;
import com.example.jsp.demo.utility.ResponseStructure;

public interface ProductService {
	    ResponseEntity<ResponseStructure<Product>> save(Product product);
	   
	    ResponseEntity<ResponseStructure<Product>> findByProductId(int id);
	    
	   
	    ResponseEntity<ResponseStructure<Product>> update(int id,Product product);

	   ResponseEntity<ResponseStructure<Product>> deleteByproductId(int id);
	    
	   
	   ResponseEntity<ResponseStructure<List<Product>>> findAll();
}
