package song;

import java.util.Scanner;

public class CalculatorSix {
	public static void main(String[] args) {
		System.out.println("식?");
		
		//스캔을 받기 위해 'Scanner' 생성자를 통한 'scan' 인스턴스를 생성
		Scanner scan = new Scanner(System.in);
		
		//'scan' 인스턴스로 받은 정보를 한 줄 전부(nextLine) 받아서 공백제거(replace 기능의 활용)하여 'input'에 넣어 선언
		String input = scan.nextLine().replace(" ", "");
		
		//'input'에 있는 정보를 한 글자씩 띄어서 (split("")) 'inputArray 배열에 넣어줌
		String[] inputArray = input.split("");
		
		//정수형 배열 'answerArray'를 선언하되, 그 크기는 'input'의 길이만큼. ('input'의 내용물만을 받는 배열이라 길이는 'input' 길이를 넘을 수 없기 때문)
		int[] answerArray = new int[input.length()];
		
		//범위의 앞쪽을 지정할 칸막이
		int partition = 0;
		
		//'answerArray'에 정보가 들어갈 때마다 '++'하여 현재 몇 번째 항인지 파악하기 위함
		int sum = 0;
		
		//최종적으로 구할 답
		int answer = 0;
		
		/**
			예시 입력 : "11 + 3 + 4 - 5 + 10"
		 
		 'input'에는 한 줄이 통째로 들어간다.(.nextLine()) 공백이 제거된 상태로(.replace(" ", "")).
		 input = "11+3+4-5+10"
		 
		 'inputArray'에는, 공백을 기준으로("") 'input'의 요소들을 분리하여(.split) 차례대로 넣어준다.
		 inputArray[0] = "1"
		 inputArray[1] = "1"
		 inputArray[2] = "+"
		 inputArray[3] = "3"
		 inputArray[4] = "+"
		 inputArray[5] = "4"
		 inputArray[6] = "-"
		 inputArray[7] = "5"
		 inputArray[8] = "+"
		 inputArray[9] = "1"
		 inputArray[10] = "0"
		 
		 'input'의 길이가 11이므로, 'answerArray' 배열의 길이는 11이 선언된다.(new int[input.length()])	
		**/
		
		
		
		//새로운 정수 'i'가 1부터 'inputArray'의 길이만큼 반복한다. 반복 사이의 간격은 1(i++)
		for(int i = 2; i < inputArray.length; i++) {
			
			//{'inputArray'의 'i'번째 항에 하나 이상(+)의 정수(\d)만(.matches) 있는가?}의 부정인가?(!)
			if(!inputArray[i].matches("\\d+") ) 	{
				
				//'answerArray'의 'sum'번째 요소에 넣는다. 무엇을? 정수화(Integer.parseInt)한 'input'변수의 부분(.substring)을. 어느정도의 부분을? 'partition'부터 'i'가 오기 전까지.
				answerArray[sum] = Integer.parseInt(input.substring(partition, i));	
			
			//이미 사용된 칸막이는, 다음 칸에는 이번 칸에 포함되지 않은 첫번째 요소(i)부터 시작할 것이다.
			partition = i;
			
			//'answerArray'는 한 번 추가되었다(++)
			sum++;	
			}
		}
		
		/** 
		해당 for문은 새로이 선언된 정수 'i'가 1부터 시작되어 'inputArray'의 길이인 11보다 작을 때에만, 1의 간격을 두고 반복된다.
		첫 번째
		'i'는 시작 숫자로 지정된(int i = 1;) 1이 된다.
			'inputArray[i]'는 'inputArray[1]'이 되며, 36~47번째 줄을 보면, 여기에는 "1"이 들어있다.
			'"1"은 숫자로만 이루어져 있는가?'(inputArray[1].matches("\\d+"))
			-> 'true'. 그러나, 앞에 부정(!)이 붙어있으므로 최종적인 출력은 'false'가 된다.
		i = 1 
		inputArray[1] = 1 
		!inputArray[1].matches("\\d+") = false
		
		두 번째
		'i'는 기존의 1에서 1만큼 증가(i++)한 2가 된다.
			'inputArray[i]'는 'inputArray[2]'가 되며, 여기에는 "+"가 들어있다.
			'"+"'은 숫자로만 이루어져 있는가? 
			->'false'. 그러나 앞에 부정이 붙어있으므로 최종적인 출력은 'true'가 된다.
			
			if문의 조건이 'true'가 된 경우엔, 
			String 변수 'input'을 특정 범위(partition, i)로 잘라서 복사(.substring)하여 answerArray[sum]에 집어넣는다.
			'input'은 문자형인 'String'으로 선언되었기에, 정수형인 'int'로 선언된 배열에 넣을 때는(Integer.parseInt)로 감싸서 집어넣는다.
			현재 'partition'과 'sum'은 초기 상태인 0이고, 'i'는 2이며, input = "11+3+4-5+10"이므로
			'input'의 0부터 2까지의 'substring'은 "11"이 된다.
			즉, answerArray[0]의 요소로 (정수화된)"11"을 집어넣게 된다.
			
			이후, 이미 사용된 칸막이 'partition'은, 이번 칸에 포함되지 않은 가장 첫 요소(i)부터 시작할 것이다.
			현재 'i'는 2이므로, 'partition'은 2가 된다.
			'sum'또한, 'answerArray'에 추가된 횟수(자리의 번호)를 0번째에서 1번째로 갱신해준다(sum++)
			'sum'은 1이 된다.
		
		
		10번을 반복하게 되기에 가독성을 챙기자면, 
		for문이 한 번이 끝날 때마다 이렇게 나오게 된다.
		(for문의 마지막에서 sum++을 해주기에, for문의 사이클이 한 번 끝날 시점의 'answerArray[sum]'은 이미 비어있는 다음 공간을 가리키므로
		이번 사이클에서 변동된 값인 'answerArray[sum - 1]'로 대체함)
		
		i	inputArray[i]	if()	| partition		sum		answerArray[sum - 1]
									|		
		1			1		false	|		0			0			-
		2			+		true	|		2			1			11	
		3			3		false	|		2			1			11
		4			+		true	|		4			2			+3
		5			4		false	|		4			2			+3
		6			-		true	|		6			3			+4
		7			5		false	|		6			3			+4
		8			+		true	|		8			4			-5
		9			1		false	|		8			4			-5
		10			0		false	|		8			4			-5
		
		다음 부호를 기준으로 앞쪽을 넣어주는 방식이기에, 
		더이상 부호가 없는 마지막 항의 경우는 따로 코드 한 줄이 필요하다.
		**/
		
		//마지막 항을 코드 한 줄로 처리해준다. 원래는 다음 부호를 기준으로 위치를 나누기 위해 사용했던 if문만 뺀 그대로의 코드이다.
		//'substring'의 범위를 (partition, i)에서 (partition)으로 하나의 숫자만 넣게 되면, 해당 번호의 요소로부터 마지막 요소까지를 잘라서 복사하게 된다.
		//즉, 'answerArray[4]'에는, (정수화된)'input' 변수의 8번째부터 마지막까지의 요소가 들어가게 된다. "+10"이 된다.
		answerArray[sum] = Integer.parseInt(input.substring(partition));
		
		
		//answerArray 배열의 모든 요소들을 더해준다.
		for(int a :answerArray) 
			answer +=a;
			
		//정답 출력
		System.out.println("답은" + answer + "입니다.");
	
	
	}//main
		
}//class
