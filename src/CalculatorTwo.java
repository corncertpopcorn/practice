package song;

import java.util.Scanner;

public class CalculatorTwo {
	
	public static void calculate() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("원하는 식을 입력하세요");
		
		int firstNumber = scan.nextInt();
		String operatorOne = scan.next();
		int secondNumber = scan.nextInt();
		String operatorTwo = scan.next();
		int thirdNumber = scan.nextInt();
		
		int answer;
		
		if(operatorOne.equals("+")) {
			if(operatorTwo.equals("+")) {
				answer = (firstNumber + secondNumber + thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("-")) {
				answer = (firstNumber + secondNumber - thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("*") || operatorTwo.equals("x") || operatorTwo.equals("X")) {
				answer = (firstNumber + (secondNumber * thirdNumber));
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("/")) {
				answer = (firstNumber + (secondNumber / thirdNumber));
				System.out.println("답:: " + answer);
			}
		}
		
		
		if(operatorOne.equals("-")) {
			if(operatorTwo.equals("+")) {
				answer = (firstNumber - secondNumber + thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("-")) {
				answer = (firstNumber - secondNumber - thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("*") || operatorTwo.equals("x") || operatorTwo.equals("X")) {
				answer = (firstNumber - (secondNumber * thirdNumber));
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("/")) {
				answer = (firstNumber - (secondNumber / thirdNumber));
				System.out.println("답:: " + answer);
			}
		}
		
		
		if(operatorOne.equals("*") || operatorOne.equals("x") || operatorOne.equals("X")) {
			if(operatorTwo.equals("+")) {
				answer = (firstNumber * secondNumber + thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("-")) {
				answer = (firstNumber * secondNumber - thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("*") || operatorTwo.equals("x") || operatorTwo.equals("X")) {
				answer = (firstNumber * secondNumber * thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("/")) {
				answer = (firstNumber * secondNumber / thirdNumber);
				System.out.println("답:: " + answer);
			}
		}
		
		
		if(operatorOne.equals("/")) {
			if(operatorTwo.equals("+")) {
				answer = (firstNumber / secondNumber + thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("-")) {
				answer = (firstNumber / secondNumber - thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("*") || operatorTwo.equals("x") || operatorTwo.equals("X")) {
				answer = ((firstNumber / secondNumber) * thirdNumber);
				System.out.println("답:: " + answer);
			}
			
			if(operatorTwo.equals("/")) {
				answer = ((firstNumber / secondNumber) / thirdNumber);
				System.out.println("답:: " + answer);
			}
		}
	}
}
