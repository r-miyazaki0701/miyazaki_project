package method.q06;

public class Cycle {
	public static void main(String[] arge) {
		double number1 = 5.0;
		double number2 = getCircleArea(number1);
		System.out.println("半径:" + number1);
		System.out.println("円の面積:" + number2);
	}

	public static double getCircleArea(double num1) {
		double number3 = num1 * num1 * 3.14;
		return number3;

	}
}
