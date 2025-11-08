package method.q09;

public class Even {
	public static void main(String[] arge) {
		int number = 10
				;
		String i = checkEven(number);
		System.out.println(number + "は" + i + "です。");
	}

	public static String checkEven(int num1) {
		if (num1 % 2 == 0) {
			return "偶数";
		} else {
			return "奇数";
		}
	}
}
