package method.q07;

public class sumNumbers2 {
	public static void main(String[] arge) {
		int number1 = 5;
		double number2 = 3.3;
		int number3 = calculateSum(number1, number2);
		//double number3 = calculateSum(number1, number2);
		System.out.println("第一引数:" + number1);
		System.out.println("第二引数:" + number2);
		System.out.println("加算結果:" + number3);
	}

	public static int calculateSum(int num1, double num2) {
		int roundnum2 = (int) Math.round(num2);
		int number4 = num1 + roundnum2;
		//System.out.println(floornum2);
		return number4;
		
	}

}
