package product;

public class Main {
	public static void main(String[] arge) {
		ProductsManager manager = new ProductsManager();

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
		System.out.println("-------------");
		manager.printProduct();
		//manager.addProduct(p1);
		//manager.addProduct(p2);
		//manager.addProduct(p3);
		//manager.addProduct(p4);
		//manager.addProduct(p5);
		//manager.displayAllProduct();
		//System.out.println(manager.getProducts());
		
		System.out.println("-------------");
		manager.removeProduct(1);
		manager.printProduct();
		
		
		System.out.println("-------------");
		Product p = manager.getProductByName("米");
		System.out.println(p);
	}
	
}
