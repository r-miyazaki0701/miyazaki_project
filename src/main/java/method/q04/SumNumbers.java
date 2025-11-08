package method.q04;

public class SumNumbers {
	public static void main(String[] arge) {
	int number1 = 3;
	int number2 = 2;
	
		int sum = calculateSum(number1, number2);
		System.out.println("第一引数:" + number1);
		System.out.println("第二引数:" + number2);
		System.out.println("加算結果:" + sum);
		
	}

	public static int calculateSum(int num1, int num2) {
		//return  num1 + num2;
		//System.out.println("第一引数:" + num1);
		//System.out.println("第二引数:" + num2);
		return num1 + num2;

	}
}
