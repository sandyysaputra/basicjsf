package id.co.skyforce.basicjsf.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="date", nullable=false)
	private Date date;
	
	@Column(name="total_amount", nullable=false)
	private BigDecimal totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Set<OrderDetail> orderDetails = new HashSet<>();

	@Column(name = "street", nullable = true)
	private String street;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "postal_code", nullable = true)
	private String postal_code;
	
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	
	public void calculateTotalAmount() {
		int total = 0;
		for (OrderDetail orderDetail : getOrderDetails()) {
			total += (int) orderDetail.getPrice().doubleValue() * orderDetail.getQuantity();
		}
		setTotalAmount(new BigDecimal(total));
	}
}
