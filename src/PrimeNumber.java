package song;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("시작과 끝을 입력");
		
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		int sum = 0;
		
		for(int i = start; i < end; i++) {
			
			for(int j = 2; j < end; j++) {
				
				if(i != j && i % j ==0) {
					
					sum ++;
				}
			}
			
			if(sum < 1 && i != 1)
				System.out.println(i);
			
			sum = 0;
		
		}
	}

}

