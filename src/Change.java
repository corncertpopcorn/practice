package song;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ChangeTwo calPrice = new ChangeTwo();
		
		System.out.println("설정할 금액은?");
		
		int price = scan.nextInt();
		
		calPrice.calculate(price);
		
	}
}
