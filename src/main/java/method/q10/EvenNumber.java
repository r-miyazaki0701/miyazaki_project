package method.q10;

import java.util.Arrays;

public class EvenNumber {
	public static void main(String[] arge) {
		int[] number = { 3, 2, 5, 6, 7, 25, 10, 51, 88, 98 };
		int evennumber = getEvenNumbers(number);
		//System.out.println(number);
		System.out.println(Arrays.toString(number) + "には、偶数が" + evennumber + "個あります。");
		//System.out.println(Arrays.toString(number));
	}

	public static int getEvenNumbers(int[] num1) {
		int count = 0;
		for (int num2 : num1) {
			if (num2 % 2 == 0) {
				count++;
			}
		}
		return count;

	}
}
