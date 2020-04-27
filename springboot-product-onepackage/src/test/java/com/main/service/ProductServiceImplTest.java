package com.main.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.main.entity.Product;
import com.main.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	
	@Test
	public void testCreateProduct() {
		Product product=new Product();
		Mockito.when(productRepository.save(product)).thenReturn(Mockito.any());
		productServiceImpl.createProduct(product);
	}

	@Test
	public void testUpdateProduct() {
		Product product=new Product();
		product.setDescription("product");
		product.setName("olay");
		product.setPrice((float) 10.5);
		Long id=(long) 1;
		product.setId(id);
		Optional<Product> productDb=Optional.of(product);
		Mockito.when(productRepository.findById(id)).thenReturn(productDb);
		productServiceImpl.updateProduct(product);
	}
	@Test
	public void testUpdateProduct1() {
		try {
			Product product = new Product();
			product.setDescription("product");
			product.setName("olay");
			product.setPrice((float) 10.5);
			Long id = (long) 1;
			product.setId(id);
			productServiceImpl.updateProduct(product);
		} catch (Exception e) {
			e.getMessage();
		}
	}


	@Test
	public void testGetAllProduct() {
		productServiceImpl.getAllProduct();
	}

	@Test
	public void testGetProductById() {
		Product product=new Product();
		long id=1;
		product.setId(id);
		Optional<Product> productDb=Optional.of(product);
		Mockito.when(productRepository.findById(id)).thenReturn(productDb);
		productServiceImpl.getProductById(id);
	}
	@Test
	public void testGetProductById1() {
		try {
			long id=1;
			productServiceImpl.getProductById(id);
	}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	@Test
	public void testDeleteProduct() {
			Product product=new Product();
			long id=1;
			product.setId(id);
			Optional<Product> productDb=Optional.of(product);
			Mockito.when(productRepository.findById(id)).thenReturn(productDb);
			productServiceImpl.deleteProduct(id);
	}
	@Test
	public void testDeleteProduct1() {
		try {
			long id=1;
			productServiceImpl.deleteProduct(id);
			}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
}
		
		
