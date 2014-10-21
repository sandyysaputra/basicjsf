package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Product;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

@ManagedBean
public class ProductListController {
	
	public List<Product> products;

	public ProductListController() {
		Session session = HibernateUtil.openSession();
		products = session.createQuery("FROM Product").list();
		session.close();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
