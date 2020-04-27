package com.main.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.main.entity.Product;
import com.main.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	@Mock
	ProductService productService;;

	@Test
	public void testGetAllProduct() {
		productController.getAllProduct();
	}

	@Test
	public void testGetProductById() {
		long id=1;
		productController.getProductById(id);
	}
	@Test
	public void testCreateProduct() {
		Product product=new Product();
		productController.createProduct(product);
	}

	@Test
	public void testUpdateProduct() {
		long id=1;
		Product product=new Product();
		productController.updateProduct(id, product);
	}

	@Test
	public void testDeleteProduct() {
		long id=1;
		productController.deleteProduct(id);
	}

}
