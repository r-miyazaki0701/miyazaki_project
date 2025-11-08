package method.q08;

public class SumLoop {
	public static void main(String[] arge) {
		int min = 1;
		int max = 100;
		System.out.println("最小値:" + min);
		System.out.println("最大値:" + max);
		int sum = sumLoop(min, max);
		System.out.println("加算結果:" + sum);
	}

	public static int sumLoop(int num1, int num2) {
		int num3 = 0;
		for (int i = num1; i <= num2; i++) {
			num3 += i;
		}
		return num3;

	}
}
