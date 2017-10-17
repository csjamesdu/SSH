package com.csjamesdu.ssh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.csjamesdu.ssh.service.ProductManager;
import com.csjamesdu.ssh.model.Product;

@Namespace("/")
@ParentPackage("struts-default")
@Results({
	@Result(name="listProduct", location="/listProduct.jsp"),
	@Result(name="listProductAction", location="listProduct", type="redirect"),
	@Result(name="editProduct", location="/editProduct.jsp"),
	@Result(name="errorPage", location="/errorPage.jsp")
	})
public class ProductAction {
	
	@Autowired
	private ProductManager productManager;
	
	private List<Product> products;
	private Product product;
	
	@Action("listProduct")
	public String list() {
		System.out.println(this);
		products = productManager.listProducts();
		return "listProduct";
	}
	
	@Action("addProduct")
	public String add() {
		productManager.addProduct(product);
		return "listProductAction";
	}
	
	@Action("deleteProduct")
	public String delete(){
		productManager.deleteProduct(product);
		return "listProductAction";
	}
	
	@Action("updateProduct")
	public String update() {
		productManager.updateProduct(product);
		return "listProductAction";
	}
	
	@Action("editProduct")
	public String edit() {
		productManager.getProductById(product.getId());
		return "editProduct";
	}
	
	@Action("insertProduct")
	public String insert() {
		productManager.insertProducts();
		return "listProductAction";
	}
	
	@Action("insertrollbackProduct")
	public String insertrollback(){
		try{
			productManager.insertProductsRollback();
		}catch(RuntimeException e){
			return "errorPage";
		}
		return "listProductAction";
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
