package basic.q08;

import java.util.Scanner;

public class inputProduct {
	public static void main(String[] arge) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("商品名を入力してください：");
		String name = scanner.nextLine();
		System.out.println("商品名を入力してください：");
		int number = scanner.nextInt();

		System.out.println("商品名は" + name + "です。価格は" + number + "円です。");
		scanner.close();

	}
}
