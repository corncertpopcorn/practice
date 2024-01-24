package song;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("123132");
		String test[] = scan.nextLine().replaceAll(" ", "").split("");
		
		for(String a : test)
			System.out.println(a);
	}

}
