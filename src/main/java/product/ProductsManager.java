package product;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager {

	private List<Product> products;

	public ProductsManager() {
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public boolean removeProduct(int id) {
		for (Product p : products) {
			if (p.getId() == id) {
				products.remove(p);
				return true;
			}
		}
		return false;
	}

	public Product getProductByName(String name) {
		for (Product p : products) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public void printProduct() {
		for (Product p : products) {
			System.out.println(p);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

}
