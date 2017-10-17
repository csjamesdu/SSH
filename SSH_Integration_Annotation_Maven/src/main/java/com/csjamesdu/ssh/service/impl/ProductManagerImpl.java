package com.csjamesdu.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csjamesdu.ssh.dao.ProductDao;
import com.csjamesdu.ssh.model.Product;
import com.csjamesdu.ssh.service.ProductManager;

@Service
public class ProductManagerImpl implements ProductManager{

	@Autowired
	private ProductDao productDao;

	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public List<Product> listProducts() {
		List<Product> products = productDao.getProdcts();
		if(products.isEmpty()) {
			for(int i=0;i<5;i++){
				Product p = new Product();
				p.setName("Product" + i);
				productDao.addProduct(p);
				products.add(p);
			}
		}
		return products;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void addProduct(Product product) {
		productDao.addProduct(product);		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void getProductById(int id) {
		productDao.loadById(id);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void insertProducts() {
		for(int i=0;i<5;i++){
			Product product = new Product();
			product.setName("AutoInsertedProduct"+i);
			product.setPrice(i*10);
			productDao.addProduct(product);
		}
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
	public void insertProductsRollback() {
		for(int i=0;i<5;i++){
			if(i==3){
				throw new RuntimeException();
			}
			Product product = new Product();
			product.setName("AutoInsertedProduct"+i);
			product.setPrice(i*10);
			productDao.addProduct(product);
		}
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
