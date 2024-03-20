package com.example.jsp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jsp.demo.model.Product;
import com.example.jsp.demo.repository.ProductRepository;
import com.example.jsp.demo.utility.ResponseStructure;

@Service
public class ProductImplementService implements ProductService{
	@Autowired
	private ProductRepository repo;
	@Override
	public ResponseEntity<ResponseStructure<Product>> save(Product product) {
		Product product1=repo.save(product);
		ResponseStructure<Product> resStruct=new ResponseStructure<Product>();
		resStruct.setMessage("Data insertes successfully");
		resStruct.setStatusCode(HttpStatus.CREATED.value());
		resStruct.setData(product1);
		return new ResponseEntity<ResponseStructure<Product>>(resStruct,HttpStatus.CREATED);
	}
	@Override
  public   ResponseEntity<ResponseStructure<Product>> findByProductId(int id){
//    	Optional<Product> product = repo.findById(id);
//    	if(product.isPresent()) {
//    		Product p = product.get();
//    		ResponseStructure<Product> respStruct=new ResponseStructure<Product>();
//    		respStruct.setStatusCode(HttpStatus.FOUND.value());
//    		respStruct.setMessage("Data Found");
//    		respStruct.setData(p);
//    		return new ResponseEntity<ResponseStructure<Product>>(respStruct,HttpStatus.FOUND);
//    	}
//    	else {
//    		throw new RuntimeException("Data not Found");
//    	}
		return repo.findById(id)
				.map(p->{ResponseStructure<Product> respStruct=new ResponseStructure<Product>();
		             respStruct.setMessage("data found");
		             respStruct.setData(p);
		             respStruct.setStatusCode(HttpStatus.FOUND.value());
				return ResponseEntity.ok(respStruct);})
				.orElseThrow(()->new RuntimeException());
    	
    }
	@Override
	public ResponseEntity<ResponseStructure<Product>> update(int productId,Product updatedProduct){
		Optional<Product> optional = repo.findById(productId);
		if(optional.isPresent()) {
			Product product = optional.get();
			updatedProduct.setProductId(product.getProductId());
			repo.save(updatedProduct);
			ResponseStructure<Product> respStruct=new ResponseStructure<Product>();
    		respStruct.setStatusCode(HttpStatus.OK.value());
    		respStruct.setMessage("Data Updated");
    		respStruct.setData(product);
    		return new ResponseEntity<ResponseStructure<Product>>(respStruct,HttpStatus.OK);	
		}
		else {
    		throw new RuntimeException("Data not Found");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByproductId(int id){
		Optional<Product> res=repo.findById(id);
		if(res.isPresent()) {
			Product product=res.get();
			
			repo.delete(product);
			ResponseStructure<Product> resStruct=new ResponseStructure<Product>();
			resStruct.setMessage("Data Deleted");
			resStruct.setStatusCode(HttpStatus.OK.value());
			resStruct.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(resStruct,HttpStatus.OK);
			
		}else {
			return null;
		}
	}
	@Override
	  public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		List<Product> products = repo.findAll();
		ResponseStructure<List<Product>> resStruct=new ResponseStructure<List<Product>>();
		resStruct.setMessage("Datas Found");
		resStruct.setStatusCode(HttpStatus.FOUND.value());
		resStruct.setData(products);
		return new ResponseEntity<ResponseStructure<List<Product>>>(resStruct,HttpStatus.FOUND);
		
	}
	}
 
