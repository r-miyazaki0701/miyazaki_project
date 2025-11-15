package product;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager {
	//プロジェクトを格納
	//private List<Product> productList = new ArrayList<>();
	//プロジェクトを追加
	//public void addProduct(Product product) {
	//productMap.put(product.getId(), product);
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

//public void addProduct(Product product) {
//productList.add(product);
//System.out.println("プロジェクトを追加しました："+ product.getName());	
//}
//IDで検索
//public Product findProductById(int id) {
//for (Product product : productList) {
//if (product.getId() == id) {
//return product;
//}
//}
//return null;
//}

//public boolean removeProduct(int id) {
//Product productRemove = findProductById(id);
//if(productRemove != null) {
//productList.remove(productRemove);
//
//return true;
//} else {
//
//return false;
//プロジェクトを削除

//}
//}
//public void displayAllProduct() {
//if(productList.isEmpty()) {
//return;
//}
//System.out.println("全てを表示");
//for (Product product : productList) {
//System.out.println(product);

//	}
//System.out.println("------");

//}

//}
