package com.csjamesdu.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.csjamesdu.ssh.dao.ProductDao;
import com.csjamesdu.ssh.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends HibernateTemplate implements ProductDao{
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	public List<Product> getProdcts() {
		return find("from Product");
	}

	public void addProduct(Product product) {
		save(product);
	}

	@Override
	public Product loadById(int id) {
		return (Product)get(Product.class,id);
	}

	@Override
	public void updateProduct(Product product) {
		update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		delete(product);
	}

}
