package id.co.skyforce.basicjsf;

import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		RequestDispatcher dispatcher = null;

		if (action != null) {
			if (action.equalsIgnoreCase("delete")) {
				Long idCust = Long.parseLong(req.getParameter("idCustomer"));
				Customer tobeDeleted = (Customer) session.get(Customer.class,
						idCust);
				session.delete(tobeDeleted);
			} else if (action.equals("getUser")) {

				Long idCust = Long.parseLong(req.getParameter("idCustomer"));
				Customer cus = (Customer) session.get(Customer.class, idCust);
				session.close();
				req.setAttribute("customer", cus);
				dispatcher = req.getRequestDispatcher("update.jsp");
				dispatcher.forward(req, resp);
				return;
			}
		}

		List<Customer> allCustomer = session.createQuery("from Customer")
				.list();
		req.setAttribute("customers", allCustomer);
		dispatcher = req.getRequestDispatcher("list.jsp");
		dispatcher.forward(req, resp);
		transaction.commit();
		session.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session;
		Transaction transaction;
		String actions = req.getParameter("action");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String homePhone = req.getParameter("homePhone");
		String mobilePhone = req.getParameter("mobilePhone");
		Date birthDay = null;
		try {
			birthDay = new SimpleDateFormat("yyyy/MM/dd").parse(req.getParameter("birthDate"));	
			} catch (Exception e) {
		}
		
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String postalCode = req.getParameter("postalCode");
		
		if (actions.equals("create")) {
			// Set data Customer
			session = HibernateUtil.openSession();
			transaction = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setHomePhone(homePhone);
			customer.setMobileNo(mobilePhone);
			customer.setBirthDate(birthDay);

			// set customer address
			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setPostalCode(postalCode);
			customer.setAddress(address);

			// Buka session untuk save melalui hibernate
			session.save(customer);
			transaction.commit();
			session.close();
			req.getRequestDispatcher("/customer/success.jsp").forward(req, resp);
		} else if (actions.equals("update")) {
			
			Long id = Long.parseLong(req.getParameter("idCustomer"));
			// Set data Customer
			session = HibernateUtil.openSession();
			Customer customer = (Customer) session.get(Customer.class, id);
			transaction = session.beginTransaction();
			System.out.println("Tanggal " +birthDay.toString());
			
			customer.setId(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setHomePhone(homePhone);
			customer.setMobileNo(mobilePhone);
			customer.setBirthDate(birthDay);
			// set customer address
			customer.getAddress().setStreet(street);
			customer.getAddress().setCity(city);
			customer.getAddress().setPostalCode(postalCode);
			// Buka session untuk save melalui hibernate
			session.saveOrUpdate(customer);
			transaction.commit();
			session.close();
			req.getRequestDispatcher("/customer/success.jsp").forward(req, resp);
			//resp.sendRedirect("crud");
		}
		//resp.sendRedirect("crud");
	}
}
