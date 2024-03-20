package com.example.jsp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsp.demo.model.Product;
import com.example.jsp.demo.service.ProductService;
import com.example.jsp.demo.utility.ResponseStructure;

@RestController
public class ProductController {
	  @Autowired
      private ProductService service;
	  @PostMapping(value="/product/save")
	  public ResponseEntity<ResponseStructure<Product>> save(@RequestBody Product product){
		  return service.save(product);
		  
	  }
	  @PutMapping(value="/product/update")
	  public ResponseEntity<ResponseStructure<Product>> update(@RequestParam int productId,@RequestBody Product product){
		  return service.update(productId, product);
	  }
	  
	  @DeleteMapping(value="/product/delete")
	  public ResponseEntity<ResponseStructure<Product>> delete(@RequestParam int productId){
		  return service.deleteByproductId(productId);
	  }
	  @GetMapping(value="/product/find")
	  public ResponseEntity<ResponseStructure<Product>> find(@RequestParam int productId){
		  return service.findByProductId(productId);
	  }
	  
	  @GetMapping(value="/product/findAll")
	  public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		  return service.findAll();
	  }
	  {
		  
	  }
}
