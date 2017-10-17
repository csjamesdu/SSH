package com.csjamesdu.ssh.dao;

import java.util.List;

import com.csjamesdu.ssh.model.*;

public interface ProductDao {
	List<Product> getProdcts();
	
	void addProduct(Product product);

	Product loadById(int id);

	void updateProduct(Product product);

	void deleteProduct(Product product);
}
