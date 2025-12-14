package product;

import java.util.Scanner;

public class Scanner_Exception {
public static void main(String[] areg) {
	Scanner scanner = new Scanner(System.in);
	//入力処理
	try {
		//商品名入力
		 System.out.print("商品名を入力してください: ");
         String name = scanner.nextLine();

         if (name == null || name.trim().isEmpty()) {
             throw new Exception("商品名が空です。");
         }
         //価格入力
         System.out.print("価格を入力してください: ");
         int price = Integer.parseInt(scanner.nextLine());

         if (price < 0) {
             throw new Exception("価格がマイナスです。");
         }
         //在庫入力
         System.out.print("在庫数を入力してください: ");
         int stock = Integer.parseInt(scanner.nextLine());

         if (stock < 0) {
             throw new Exception("在庫数がマイナスです。");
         }
         //System.out.println(name + price + stock);
         
	  } catch (NumberFormatException e) {
          System.out.println("数値の形式が不正です: " + e.getMessage());
      } catch (Exception e) {
          System.out.println("入力エラー: " + e.getMessage());
      } finally {
          scanner.close();

	
	
	
}
}
}