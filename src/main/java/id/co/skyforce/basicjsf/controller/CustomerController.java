package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String homePhone;
	private String mobilePhone;
	private Date birthDate;
	private String street;
	private String city;
	private String postalCode;
	private String salutation;
	private Character gender;
	private Long customerId;
	private Long addressId;

	public CustomerController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		if (id != null) {
			customerId = Long.valueOf(id);
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class,
					customerId);

			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			email = customer.getEmail();
			password = customer.getPassword();
			homePhone = customer.getHomePhone();
			mobilePhone = customer.getMobileNo();
			birthDate = customer.getBirthDate();
			street = customer.getAddress().getStreet();
			city = customer.getAddress().getCity();
			postalCode = customer.getAddress().getPostalCode();
			salutation = customer.getSalutation();
			gender = customer.getGender();
			addressId = customer.getAddress().getId();
			transaction.commit();
			session.close();
		}
	}

	public String save() {

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobilePhone);
		customer.setBirthDate(birthDate);
		customer.setGender(gender);
		customer.setSalutation(salutation);
		// set customer address
		Address address = new Address();
		address.setId(addressId);
		address.setStreet(street);
		address.setCity(city);
		address.setPostalCode(postalCode);
		customer.setAddress(address);
		// Buka session untuk save melalui hibernate
		
		session.saveOrUpdate(customer);
		transaction.commit();
		session.close();
		clearForm();
		return "/customer/list";
	}

	private void clearForm() {
		firstName = null;
		lastName = null;
		email = null;
		password = null;
		homePhone = null;
		mobilePhone = null;
		birthDate = null;
		street = null;
		city = null;
		postalCode = null;

	}
	

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getAddress() {
		return addressId;
	}

	public void setAddress(Long address) {
		this.addressId = address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
