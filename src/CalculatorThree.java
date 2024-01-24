package song;

import java.util.Scanner;

/**
 12일 수업을 들은 이후에 다시 생각해본, 
 	못짰던 원인 분석 : 
 	
 	1. 코드의 모양새 만들기 - 문제없음
 	2. 수업 내용 복습시 문맥 파악 - 문제없음
 	3. indexOf, split 등의 기능 - 제대로 모름
 	
 	결론 : 기본기 부족. 
 		-이전 선생님의 책도 지금 다시 훑었으나, Scanner, indexOf 등의 기능은 존재하지 않음. 
 		 왜 그런지 목차를 보니, 활용보단 기본 틀을 설명해주기 위한 책이기 때문인 모양.
 		 
 	해결방안 : 현재 알게 된 split, indexOf, trim 등의 기능과, 정리글에서 같이 언급되는 기능들을 '눈에 익히기'라도(외우지 못하더라도 존재여부는 기억하도록) 해놓기
 	
 	여기까지 마친 후, 금요일 수업을 다시 복습에 들어감
 	-----
 	다시 읽어보니, 
 	1. '+'와 '-' 중 어느 것이 먼저 있는지 파악
 	2. indexOf로 정확한 위치 파악 (연산당할 숫자의 자릿수가 1자리 고정이 아니므로 연산자의 위치가 2일 수도 있고 3일 수도 있으니) 
 	3. 가장 앞에 있는 연산자를 빼버리며 앞에 있는 숫자도 같이 제거하는 방식으로 마무리
 	-----
 	기능의 이해가 완료되었으니, 굳이 '+'와 '-'만 있는 기능으로 만들 필요가 없었음.
 	아직 공학용 계산기는 무리더라도, '*'와 '/'를 추가하여, 사칙연산 순서(곱하기와 나누기를 먼저 계산)까지 첨가한 방식으로 해보기로 함
 	-----
 **/
/**
 	1차 구상
 	
 	1. indexOf로 첫 연산자의 위치를 파악하기
 	2. 해당 연산자의 바로 앞까지 잘라내어 저장하기를 반복(12+34-56*78/90인 경우, '12',  '+34-56*78/90'의 둘로 나누기)
 		2-1. 단일 숫자, 부호가 붙은 숫자('+34', '-56', '*78', '/90') 형식으로 저장을 끝내며 마지막 항의 예외 처리까지 마무리
 		2-2. 진행하면서, '*'와 '/'의 위치는 따로 저장해두기
 	3. '*'와 '/'를 연산해주기
 	4. 모두 더하기

 	
 **/
/**
  	2차 구상 - .matches와 .substring에 대해 알게 되어 활용
  	
  	1. replace로 공백을 없애고 받아 String과 String[]에 각각 넣어주기
  	2. for문에  matches를 넣어 String[]의 모든 요소를 정수인지 확인하기
 		2-1. String[i]에서 찾았다면 .substring을 통해 String을 (i-1)까지 잘라 answer[]에 따로 빼고, 남은 부분을 String에 다시 넣기
 		2-2. 2-1의 시행마다 sum++을 해주어 answer[sum]의 항의 위치 파악하기
 		2-3. 2-1의 시행마다 .contains를 돌려 '*'와 '/'의 위치를 따로 기록하기
 	3. 단일 숫자, 부호가 붙은 숫자('12', '+34', '-56', '*78', '/90') 형식으로 저장을 끝내며 마지막 항의 예외 처리까지 마무리
  	4. '*'와 '/'를 연산해주기
 	5. 모두 더하기 
 **/

public class CalculatorThree {
	public static void cal() {
		//일단 입력을 받아야겠지?
		Scanner scan = new Scanner(System.in);
		
		System.out.println("식을 입력하세요");
		
		String question = scan.nextLine().replace(" ", "");
		String questionTwo[] = question.split("");
		
		//최종적으로 연산하게 될 식의 항의 순서 ('12', '+34', '-56', '*78', '/90')
		int sum = 0;
		
		//최종적으로 연산하게 될 항의 모음집
		String answer[] = new String[10];
		
		//연산을 위한 숫자 배열
		double answerD[] = new double[10];
		
		//우선순위 연산 (곱하기,나누기)
		boolean times[] = new boolean[10];
		
		//우선순위 - 나눗셈
		boolean divide[] = new boolean[10]; 
		
		//앞쪽이 절취됐음을 알리는 칸막이
		int partition = 0;
		
		
		
		//포문의 길이는 대충 배열의 길이로 정했는데, 이래도 되는 건가 모르겠음
		for(int i = 0; i < questionTwo.length; i++) {
			//정수가 아닌, 즉 연산자의 위치를 찾기 위한 if문
			if(!questionTwo[i].matches("\\d+")) {
				
				//question과 questionTwo의 내용물의 위치가 같다는 점을 이용해서 절취
				//몇 번째로 절취되었나?(sum)
				answer[sum] = question.substring(partition, i);
				
				//칸막이에 i를 넣어서 위치 설정
				partition = i;			
				
				//우선순위 연산자를 가지고 있나요?
				if(answer[sum].contains("\\*") || answer[sum].contains("\\/")) {
					//네
					times[sum] = true;
					
					//나눗셈인가요?
					if(answer[sum].contains("\\/"))
							divide[sum] = true;
				}
				//다음에 올 항의 번호로 올려주기
				sum++;
			}
		} //for		
		
		//마지막 항 처리
		answer[sum] = question.substring(partition);
				
		if(answer[sum].contains("\\*") || answer[sum].contains("\\/")) {
				times[sum] = true;	
					
				if(answer[sum].contains("\\/"))
					divide[sum] = true;
		}
						
		for(String k : answer) {
			System.out.print(k);
			System.out.print(" ");
		}
		//연산을 위해 String에서 Double로 변경
		//'*', '/'가 붙어있는 항은 변경이 불가하니 제외
		for(int j = 0; j <= sum; j++) {
			if(!times[j])
				answerD[j] = Double.parseDouble(answer[j]);		
			else 
				answer[j] = answer[j].substring(1);
		}		
		
			
		//우선순위 연산 ('*', '/')
		for(int k = 0; k < times.length; k++) {
			//나눗셈인가요?
			if(divide[k]) {
				if(k != 0 && times[k-1] == false )
				answerD[k-1] /= Double.parseDouble(answer[k]);
				answerD[k] = 1;
				
				if(k != 0 && times[k-1] == true ) {
					for(int l = k; l > 0; l--) {
						if (times[l] == false) {
							answerD[l] /= Double.parseDouble(answer[k]);
							answerD[k] = 1;
						}
					}
				}
			}
			
			//나눗셈이 아닌가요?
			if(divide[k]) {
				if(k != 0 && times[k-1] == false )
				answerD[k-1] *= Double.parseDouble(answer[k]);
				answerD[k] = 1;
				
				if(k != 0 && times[k-1] == true ) {
					for(int l = k; l > 0; l--) {
						if (times[l] == false) {
							answerD[l] *= Double.parseDouble(answer[k]);
							answerD[k] = 1;
						}
					}
				}
			}
		} //for
		
		double lastAnswer = 0;
		for(int c = 0; c < answerD.length; c++) {
			if(answerD[c] == 1 && times[c] == true)
				continue;
			else
				lastAnswer += answerD[c];
		}
		System.out.println(lastAnswer);
		for(int a = 0; a < answer.length; a++) {
			System.out.print(answer[a]);
			System.out.print(" ");
		}
		System.out.println("");
		for(int b = 0; b < answerD.length; b++) {
			System.out.print(answerD[b]);		
			System.out.print(" ");
		}
	} //cal
	

} //class






















