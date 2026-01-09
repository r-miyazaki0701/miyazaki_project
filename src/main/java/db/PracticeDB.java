package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//データべースに接続
public class PracticeDB {
	private static final String url = "jdbc:mysql://localhost:3306/product_management";
	private static final String user = "root";
	private static final String password = "rentaro0701";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {
			System.out.println("データベース接続成功");
			while (resultSet.next()) {
			}
		} catch (Exception e) {
			System.out.println("データベース接続失敗");
			e.printStackTrace();
		}

		while (true) {
			System.out.println("---メニュー---");
			System.out.println("1:データ追加");
			System.out.println("2:データ更新");
			System.out.println("3:データ削除");
			System.out.println("0:終了");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				INSERTp();
				break;

			case "2":
				UPDATEp();
				break;

			case "3":
				DELETEp();
				break;

			case "0":
				System.out.println("終了します");
				scanner.close();
				return;
			}
		}
	}

	//データ追加
	public static void INSERTp() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("商品名を入力してください: ");
		String name = scanner.nextLine();

		System.out.print("価格を入力してください: ");
		int price = scanner.nextInt();

		System.out.print("在庫数を入力してください: ");
		int stock = scanner.nextInt();

		System.out.print("カテゴリーIDを入力してください: ");
		int category_id = scanner.nextInt();

		String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);
			pstmt.setInt(4, category_id);

			 //pstmt.executeUpdate();これが二個あったから重複して登録されていた
			
			int count = pstmt.executeUpdate();
			System.out.println("登録成功件数：" + count + "件");
			System.out.println("登録内容："+ "商品名：" + name + ", 価格：" + price + ", 在庫数：" + stock + ",  カテゴリーID：" + category_id);
		} catch (SQLException e) {
			System.out.println("データの追加に失敗しました");
			e.printStackTrace();
		}
	}

	//データ更新
	public static void UPDATEp() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("商品IDを入力してください: ");
		int id = scanner.nextInt();
		System.out.print("価格を入力してください: ");
		int price = scanner.nextInt();
		System.out.print("在庫数を入力してください: ");
		int stock = scanner.nextInt();
//stockの後にコンマがあったことが原因
		String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, price);
			pstmt.setInt(2, stock);
			pstmt.setInt(3, id);

			//pstmt.executeUpdate();

			int count = pstmt.executeUpdate();
			System.out.println("登録成功件数：" + count + "件");
			System.out.println("登録内容; " + "商品ID;　" + id + ", 価格: " + price + ", 在庫数: " + stock);
		} catch (SQLException e) {
			System.out.println("更新失敗");
			e.printStackTrace();
		}
		
	}

	//データ削除
	public static void DELETEp() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("削除するカテゴリーIDを入力してください: ");
		int category_id = scanner.nextInt();

		String sql = "DELETE FROM products WHERE category_id = ?";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, category_id);

			//pstmt.executeUpdate();

			int count = pstmt.executeUpdate();
			System.out.println("削除成功件数：" + count + "件");
		} catch (SQLException e) {
			System.out.println("データの削除に失敗しました");
			e.printStackTrace();
		}
		
	}
}
