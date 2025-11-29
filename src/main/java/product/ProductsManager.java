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

	//削除メソッド
	public boolean removeProduct(int id) {
		for (Product p : products) {
			if (p.getId() == id) {
				products.remove(p);
				return true;
			}
		}
		return false;
	}

	//名前で検索メソッド
	public Product getProductByName(String name) {
		for (Product p : products) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	//全商品表示
	public void printProduct() {
		for (Product p : products) {
			System.out.println(p);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	//割引商品表示
	public void printdiscountedProducts() {
		for (Product x : products) {
			System.out.println(x);
		}
	}

	//searchメソッド
	public List<Product> search(String keyword) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getName().contains(keyword)) {
				result.add(p);
			}
		}
		return result;

	}
}
