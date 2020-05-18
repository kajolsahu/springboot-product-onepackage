package com.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Product;
import com.main.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@Cacheable(value = "products")
	@GetMapping("/products")
	public List<Product> getAllProduct() {
        System.out.println("Getting the whole records");
        return productService.getAllProduct();
    }
	
	@Cacheable(value = "products",key="#id")
	@ResponseBody
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable long id){
		System.out.println("Getting the records by Product ID");
		return productService.getProductById(id);
	}
	@Cacheable(value = "products",key="#product")
	@ResponseBody
	@PostMapping("/products/add")
	public Product createProduct(@RequestBody @Valid Product product){
		System.out.println("Creating New records");
		return productService.createProduct(product);
	}
	@CachePut(value = "products",key="#id")
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product){
		product.setId(id);
		System.out.println("Updating the records by ID");
		return productService.updateProduct(product);
	}
	@CacheEvict(value = "products",key="#id")
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		System.out.println("Deleting records by ID");
		return "Successfully deleted";
	}
	
	@CacheEvict(value = "products", allEntries=true)
	@RequestMapping("/clearcache")
	public String clearCache()
	{
		return "Cache is Cleared";
	}
		
}
