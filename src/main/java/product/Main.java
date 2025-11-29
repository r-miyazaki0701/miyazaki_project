package product;

import java.util.List;

public class Main {
	public static void main(String[] arge) {
		ProductsManager manager = new ProductsManager();
		//商品情報追加
		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		manager.addProduct(new Product(2, "ソファ", 30000, 50));
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));
		//Product p1 = new Product(1, "冷蔵庫", 50000, 10);
		//Product p2 = new Product(2, "ソファ", 30000, 5);
		//Product p3 = new Product(3, "米", 2000, 3);
		//Product p4 = new Product(4, "小説", 1500, 4);
		//Product p5 = new Product(5, "Tシャツ", 1500, 5);
		//manager.addProduct(new Product(1, "冷蔵庫", 50,000, 10));
		//manager.displayAllProduct();
		//全商品表示
		System.out.println("-------------");
		manager.printProduct();
		//manager.addProduct(p1);
		//manager.addProduct(p2);
		//manager.addProduct(p3);
		//manager.addProduct(p4);
		//manager.addProduct(p5);
		//manager.displayAllProduct();
		//System.out.println(manager.getProducts());
		//idを引数に削除
		System.out.println("-------------");
		manager.removeProduct(1);
		manager.printProduct();
		//名前で検索
		System.out.println("-------------");
		Product p = manager.getProductByName("米");
		System.out.println(p);
		//}
		//割引情報を追加で表示　
		System.out.println("-------------");
		manager.removeProduct(2);
		manager.removeProduct(3);
		manager.removeProduct(4);
		manager.removeProduct(5);
		manager.addProduct(new DiscountedProduct(1, "冷蔵庫", 50000, 10, 0.2));
		manager.addProduct(new DiscountedProduct(2, "ソファ", 30000, 50, 0.3));
		manager.addProduct(new DiscountedProduct(3, "米", 2000, 3, 0.1));
		manager.addProduct(new DiscountedProduct(4, "小説", 1500, 4, 0.5));
		manager.addProduct(new DiscountedProduct(5, "Tシャツ", 1500, 5, 0.4));
		manager.printdiscountedProducts();
		//名前で検索
		System.out.println("-------------");
		List<Product> results = manager.search("ソファ");
		//Productのリストから縫い威力されたのがないか捜索し、出力
		for (Product x : results) {
			System.out.println(x);

		}
	}

}
