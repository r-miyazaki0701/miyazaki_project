package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductsManager {

	private static List<Product> products = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] arge) {
		while (true) {
			System.out.println("---メニュー---");
			System.out.println("1:商品追加");
			System.out.println("2;商品情報取得");
			System.out.println("3:商品検索");
			System.out.println("4:商品全て表示");
			System.out.println("5;商品削除");
			System.out.println("0:終了");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				//商品追加メソッド呼び出し
				addProduct();
				break;
			case "2":
				//商品情報取得メソッド呼び出し
				productsearch();
				break;
			case "3":
				//商品検索メソッド呼び出し
				getProductByName();
				break;
			case "4":
				//全商品表示メソッド呼び出し
				printProduct();
				break;
			case "5":
				//商品削除メソッド呼び出し
				removeProduct();
				break;
			case "0":
				//終了
				System.out.println("終了します");
				//System.exit(0);
				scanner.close();
				return;

			}
		}
	}

	//商品追加メソッド 
	public static void addProduct() {
		Scanner scanner = new Scanner(System.in);
		//入力処理
		try {
			//id入力
			System.out.println("IDを入力してください: ");
			int id = Integer.parseInt(scanner.nextLine());

			if (id < 0) {
				throw new Exception("IDがマイナスです。");
			} // }が1つ足りない
				//商品名入力
			System.out.println("商品名を入力してください: ");
			String name = scanner.nextLine();

			if (name == null || name.trim().isEmpty()) {
				throw new Exception("商品名が空です。");
			}
			//価格入力
			System.out.println("価格を入力してください: ");
			int price = Integer.parseInt(scanner.nextLine());

			if (price < 0) {
				throw new Exception("価格がマイナスです。");
			}
			//在庫入力
			System.out.println("在庫数を入力してください: ");
			int stock = Integer.parseInt(scanner.nextLine());

			if (stock < 0) {
				throw new Exception("在庫数がマイナスです。");
			}
			//リストに情報を追加
			products.add(new Product(id, name, price, stock)); //1行にする
			System.out.println("商品を登録しました。");
		}
		//例外処理
		catch (NumberFormatException e) {
			System.out.println("数値の形式が不正です: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("入力エラー: " + e.getMessage());
		}
		//scanner.closeを消すと上手く動く　なぜ？
		finally {
		//scanner.close();
		}
	}

	//入力された情報をリストに追加
	//addProduct(new Product(name, price, stock));
	//System.out.println(name +"を追加しました。");

	//idを引数に削除メソッド　
	public static void removeProduct() {
		System.out.println("削除するIDを入力してください: ");
		int id = Integer.parseInt(scanner.nextLine());
		for (Product p : products) {
			if (p.getId() == id) {
				products.remove(p);
				System.out.println(p + "を削除しました。");
			}
		}
	}

	//名前で検索メソッド 部分ヒットができるようにしたい　
	public static void getProductByName() {
		System.out.println("商品名を入力してください: ");
		String a = scanner.nextLine();

		for (Product c : products) {
			if (c.getName().contains(a)) {
				System.out.println("商品情報;" + c);
			} else {
				System.out.println("登録されている商品がありません");
				return;
			}
		}
	}

	//全商品表示 
	public static void printProduct() {

		for (Product p : products) {
			System.out.println(p);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	//商品情報取得メソッド
	public static void productsearch() {
		System.out.println("商品名を入力してください: ");
		String s = scanner.nextLine();

		for (Product x : products) {
			if (x.getName().equals(s)) {
				System.out.println("商品情報;" + x);
			} else {
				System.out.println("登録されている商品がありません");
				//	return;
			}
		}
		//System.out.println("登録されている商品がありません");
	}

	//割引商品表示
	public void printdiscountedProducts() {
		for (Product x : products) {
			System.out.println(x);
		}
	}

	//searchメソッド
	public static List<Product> search(String keyword) {
		List<Product> result = new ArrayList<>();

		for (Product p : products) {
			if (p.getName().contains(keyword)) {
				result.add(p);
			}
		}
		return result;

	}

}
