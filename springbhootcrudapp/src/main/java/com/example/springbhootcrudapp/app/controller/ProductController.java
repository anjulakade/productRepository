package com.example.springbhootcrudapp.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbhootcrudapp.app.model.Product;
import com.example.springbhootcrudapp.app.servicei.ProductServicei;
@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductServicei psi;
	@PostMapping("/product")
	public Product  saveProduct(@RequestBody Product p) 
	{
		Product product=psi.saveProduct(p);
		
		return product;
  
	}
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		 List<Product> pList=psi.getProducts();
		return pList;
		
	}
	@GetMapping("/product/{productId}")
	public  Optional<Product> getProductById(@PathVariable Integer productId)
	{
	Optional<Product> product=psi.getProductById(productId);
	  return product;
	}
	  @PutMapping("/product/{productId}")
	  public Product updateProduct(@PathVariable Integer productId, @RequestBody Product p) {
		  Product product=psi.updateProduct(productId,p);
		  return product;
	}
	 @DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable Integer productId) 
	 { 
		 psi.deleteProduct(productId);
		 
		 }
}
