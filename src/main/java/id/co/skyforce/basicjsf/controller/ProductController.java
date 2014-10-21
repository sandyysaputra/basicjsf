package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Category;
import id.co.skyforce.basicjsf.domain.Product;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ProductController {
	private Long category;
	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;
	private List<Category> categories;
	private Long productId;
	private String search;

	public ProductController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		if (id != null) {
			productId = Long.valueOf(id);
			Session session = HibernateUtil.openSession();
			Product product = (Product) session.get(Product.class, productId);

			category = product.getCategory().getId();
			name = product.getName();
			price = product.getPrice();
			stock = product.getStock();
			description = product.getDescription();
			session.close();
		}
	}

	@PostConstruct
	public void init() {
		Session session = HibernateUtil.openSession();
		categories = session.createQuery("FROM Category").list();
		session.close();
	}

	public String delete() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		
			productId = Long.valueOf(id);
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = (Product) session.get(Product.class, productId);
			session.delete(product);
			transaction.commit();
			session.close();
		return "product/list";
	}

	public String save() {
		Product product = new Product();
		product.setId(productId);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDescription(description);

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Category categoryObj = (Category) session.get(Category.class, category);

		product.setCategory(categoryObj);
		session.saveOrUpdate(product);
		transaction.commit();
		session.close();

		return "/product/list";
	}
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public String getProduct() {
		return name;
	}

	public void setProduct(String product) {
		this.name = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
