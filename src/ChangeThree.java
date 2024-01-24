package song;

public class ChangeThree {
	public int price;
	public int calPrice;
	public int change;
	
	int tenThousand = 0;
	int fiveThousand = 0;
	int oneThousand = 0;
	int fiveHundred = 0;
	int oneHundred = 0;
	int fifty = 0;
	int ten = 0;
	
	
	
	
	public void calculate(int price) {
		this.price = price;
		change = 50000 - price;
		calPrice = price;
		
		tenThousand  = calPrice % 10000;

			calPrice -=10000 * tenThousand;
			
		fiveThousand = calPrice % 5000;
		
			calPrice -=5000 * fiveThousand;
			
		oneThousand  = calPrice % 1000;
	
			calPrice -=1000 * oneThousand;
			
		fiveHundred  = calPrice % 500;
	
			calPrice -=500 * fiveHundred;
		
		oneHundred   = calPrice %100;
		
			calPrice -=100 * oneHundred;
			
		fifty        = calPrice % 50;
		
			calPrice -=50 * fifty;
			
		ten          = calPrice % 10;
		
			calPrice -=10 * ten;
					 

		System.out.println("오만 원을 받았습니다.");
		System.out.println("가격은 " + price + "윈입니다.");
		System.out.println("거스름돈은 " + change + "원이며");
		System.out.println("만 원 지폐 : " + tenThousand + "장");
		System.out.println("오천 원 지폐 : " + fiveThousand + "장");
		System.out.println("천 원 지폐 : " + oneThousand + "장");
		System.out.println("오백 원 동전 : " + fiveHundred + "개");
		System.out.println("백 원 동전 : " + oneHundred + "개");
		System.out.println("오십 원 동전 : " + fifty + "개");
		System.out.println("십 원 동전 : " + ten + "개");
		System.out.println("드리겠습니다.");

		
	}
}
