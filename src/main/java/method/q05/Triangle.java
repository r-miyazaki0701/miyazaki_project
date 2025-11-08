package method.q05;

//import java.util.Scanner;

public class Triangle {
	public static void main(String[] arge) {
		int number1 = 8;
		int number2 = 5;
		//Scanner scanner = new Scanner(System.in);
		//System.out.println("底辺を入力してください：");
		//int number1 = scanner.nextInt();
		//System.out.println("高さを入力してください：");
		//int number2 = scanner.nextInt();
		int number3 = getTriangleArea(number1, number2);
		System.out.println("底辺:" + number1);
		System.out.println("高さ:" + number2);
		System.out.println("三角形の面積：" + number3);
		//scanner.close();
	}

	public static int getTriangleArea(int num1, int num2) {
		//System.out.println("底辺："+ num1);
		//System.out.println("高さ："+ num2);
		return num1 * num2 / 2;

	}
}
