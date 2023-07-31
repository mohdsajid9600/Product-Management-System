package productcurdapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcurdapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Create Product...........
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}

	// Get Product..........
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}

	// Get All Products................
	public List<Product> getProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}

	// Delete Product..............
	@Transactional
	public void deleteProduct(int pid) {
		Product product = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(product);
	}

	// Update Product..............
	@Transactional
	public void updateProduct(Product product) {
		this.hibernateTemplate.update(product);
	}
}
