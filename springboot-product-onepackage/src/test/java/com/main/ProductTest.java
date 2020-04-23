package com.main;

import static org.junit.Assert.*;

import java.beans.IntrospectionException;

import org.junit.Test;

import net.codebox.javabeantester.JavaBeanTester;

public class ProductTest {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(Product.class);
	}

}
