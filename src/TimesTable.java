package song;

public class TimesTable {

	public static void main(String[] args) {
		
		
		
		for(int i=3; i<=12; i++) {
			System.out.println(i + "단");
			for(int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println("\n");
			
		}
	}

}
