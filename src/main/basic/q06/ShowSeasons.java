package basic.q06;

public class ShowSeasons {
	public static void main(String[] arge) {
		String months = "8";

		switch (months) {
		case "1", "2", "12":
			System.out.println("冬");
			break;
		case "3", "4", "5":
			System.out.println("春");
			break;
		case "6", "7", "8":
			System.out.println("夏");
			break;
		case "9", "10", "11":
			System.out.println("秋");
			break;
		}
	}
}
