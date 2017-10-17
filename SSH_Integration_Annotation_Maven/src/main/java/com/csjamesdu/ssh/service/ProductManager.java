package com.csjamesdu.ssh.service;

import java.util.List;

import com.csjamesdu.ssh.model.*;

public interface ProductManager {
	public List<Product> listProducts();

	public void addProduct(Product product);

	public void deleteProduct(Product product);

	public void updateProduct(Product product);

	public void getProductById(int id);

	public void insertProducts();

	public void insertProductsRollback();
	
}
