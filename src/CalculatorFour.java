package song;

public class CalculatorFour {
	public static void cal() {
		//TODO :: 1) matches(정규식)을 이용해서 정수가 아닌 부분을 찾기.
	    String inputStr = "11+2+3+4-5-6-7-8".replaceAll(" ","");
	    String [] inputStrObjArr = inputStr.split("");

	    int sum = 0 ;
	    double [] numberArr = new double[inputStr.length()];
	    int partition = 0;
	    double answer = 0;
	    boolean [] minus  = new boolean[inputStr.length()];
	    String temp = "";
	  
	    
	    
	    System.out.println("numberArr[sum]" + "\t"+ "temp"  + "\t" + "sum"  + "\t" + "minus[sum]");
	    
	//TODO :: 2) subString을 이용해서 부호 + 정수 형식으로 잘라서 배열에 저장하기
	    for(int i =1; i< inputStrObjArr.length; i++){
	       if(!inputStrObjArr[i].matches("\\d+") ){ // 정수가 아니면.
	          temp = inputStr.substring(partition,i);
	          numberArr[sum] = Double.parseDouble(temp);
	          if(inputStrObjArr[i].equals("-")){
	             minus[sum + 1]=true;
	          }
	          System.out.print(numberArr[sum] + "\t\t"+ temp  + "\t" + sum  + "\t" + minus[sum]);
		       System.out.println("");
	         partition = i;
	         sum++;
	       }
	       
	    }
	    numberArr[sum] = Double.parseDouble(inputStr.substring(partition));
	    
	    for(double a : numberArr)
	    	answer += a;
	    System.out.println(numberArr[sum] + "\t\t"+ temp  + "\t" + sum  + "\t" + minus[sum]);
	    System.out.println("정답은 "+ answer + "입니다.");
	    
	}
}
