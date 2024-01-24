package song;


public class ChangeTwo {
	int tenThousand = 0;
	int fiveThousand = 0;
	int oneThousand = 0;
	int fiveHundred = 0;
	int oneHundred = 0;
	int fifty = 0;
	int ten = 0;
	int price;
	int calPrice;
	int change;
	
	
	public int overTenThousand(int price) {
		this.calPrice = price;
		if(calPrice >= 10000) {
			calPrice -= 10000;
			tenThousand += 1;
			return overTenThousand(calPrice);
		}
		else
			return overFiveThousand(calPrice);
	}
	
	public int overFiveThousand(int price) {
		this.calPrice = price;
		if(calPrice >= 5000) {
			calPrice -= 5000;
			fiveThousand += 1;
			return overFiveThousand(calPrice);
		}
		else
			return overOneThousand(calPrice);
	}

	public int overOneThousand(int price) {
		this.calPrice = price;
		if(calPrice >= 1000) {
			calPrice -= 1000;
			oneThousand += 1;
			return overOneThousand(calPrice);
		}
		else
			return overFiveHundred(calPrice);
	}
	
	public int overFiveHundred(int price) {
		this.calPrice = price;
		if(calPrice >= 500) {
			calPrice -= 500;
			fiveHundred += 1;
			return overFiveHundred(calPrice);
		}
		else
			return  overOneHundred(calPrice);
	}
	
	public int overOneHundred(int price) {
		this.calPrice = price;
		if(calPrice >= 100) {
			calPrice -= 100;
			oneHundred += 1;
			return  overOneHundred(calPrice);
		}
		else
			return overFifty(calPrice);
	}
	
	public int overFifty(int price) {
		this.calPrice = price;
		if(calPrice >= 50) {
			calPrice -= 50;
			fifty += 1;
			return overFifty(calPrice);
		}
		else
			return overTen(calPrice);
	}
	
	public int overTen(int price) {
		this.calPrice = price;
		if(calPrice >= 10) {
			calPrice -= 10;
			ten += 1;
			return overTen(calPrice);
		}
		else
			return 0;
	}
	
	public void calculate(int price) {
		this.price = price;
		change = 50000 - price;
		 overTenThousand(change);
		
		
		
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
