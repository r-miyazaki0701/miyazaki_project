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
	//メインでしか使えないのを全体で使えるようにプライベートにした
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
		System.out.print("--商品の登録--");
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

			//pstmt.executeUpdate();

			int count = pstmt.executeUpdate();
			System.out.println("登録成功件数：" + count + "件");
			System.out.println(
					"登録内容：" + "商品名：" + name + ", 価格：" + price + ", 在庫数：" + stock + ",  カテゴリーID：" + category_id);
		} catch (SQLException e) {
			System.out.println("データの追加に失敗しました");
			e.printStackTrace();
		}
	}

	//データ更新
	public static void UPDATEp() {
		Scanner scanner = new Scanner(System.in);

		int count1 = 0;
		int count2 = 0;
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			connection.setAutoCommit(false);
			try {
				System.out.println("--商品の価格と在庫の更新➀--");
				System.out.print("商品IDを入力してください: ");
				int id1 = scanner.nextInt();
				System.out.print("価格を入力してください: ");
				int price1 = scanner.nextInt();
				System.out.print("在庫数を入力してください: ");
				int stock1 = scanner.nextInt();
				String sql1 = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
				try (PreparedStatement pstmt1 = connection.prepareStatement(sql1)) {
					pstmt1.setInt(1, price1);
					pstmt1.setInt(2, stock1);
					pstmt1.setInt(3, id1);

					//int count1 = pstmt1.executeUpdate();
					count1 = pstmt1.executeUpdate();
					//例外が発生していないからロールバックしない

					//if (count1 == 0) {
					//throw new SQLException();
					//}
					//1の方でエラーが出るとその段階でスローされてロールバックされる

				}
				System.out.println("--商品の価格と在庫の更新②--");
				System.out.print("商品IDを入力してください: ");
				int id2 = scanner.nextInt();
				System.out.print("価格を入力してください: ");
				int price2 = scanner.nextInt();
				System.out.print("在庫数を入力してください: ");
				int stock2 = scanner.nextInt();
				String sql2 = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
				try (PreparedStatement pstmt2 = connection.prepareStatement(sql2)) {
					pstmt2.setInt(1, price2);
					pstmt2.setInt(2, stock2);
					pstmt2.setInt(3, id2);

					//int count2 = pstmt2.executeUpdate();

					count2 = pstmt2.executeUpdate();
					//if (count2 == 0) {
					//throw new SQLException();
					//}
				}
				//例外を飛ばす
				if (count1 == 0) {
					throw new SQLException();
				}
				if (count2 == 0) {
					throw new SQLException();
				}
				connection.commit();
				System.out.println("コミット成功");
				//件数数え　countを最初に定義してそこにカウントするようにした
				//中から外に出力から外に中の情報が入るようにした
				int count3 = count1 + count2;
				System.out.println("登録成功件数：" + count3 + "件");
				//変更内容表示
				System.out.println("更新内容➀; " + "商品ID;" + id1 + ", 価格: " + price1 + ", 在庫数: " + stock1);
				System.out.println("更新内容②; " + "商品ID;" + id2 + ", 価格: " + price2 + ", 在庫数: " + stock2);
			} catch (SQLException e) {
				//例外が発生していないからロールバックしない
				connection.rollback();
				int count3 = count1 + count2;
				System.out.println("登録成功件数：" + count3 + "件");
				System.out.println("ロールバックしました");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("データベース接続失敗");
		}
	}
	//データ削除
	public static void DELETEp() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("---商品を削除(カテゴリーID指定)--");
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

