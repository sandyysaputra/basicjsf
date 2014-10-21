package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Customer;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerListController {
	
	public List<Customer> customers;

	public CustomerListController() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		customers = (List<Customer>) session.createQuery("FROM Customer").list();
		transaction.commit();
		session.close();
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
