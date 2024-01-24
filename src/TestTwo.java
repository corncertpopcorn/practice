package song;

public class TestTwo {
    /** TODO :: 문제 :: + 연산자와 - 연산자만 사용 가능한, 계산기 만들기.
     *     해야 될 일
     *     1) 문자열을 받는다. (nextLine)
     *     2) +연산자와 -연산자 양 옆에 있는 애들이 뭔지 확인한다. (split('+') or split('-') )
     *        ((((1+2)+3)-4)-5)+6-7+8를 입력받음.
     *        1+2가 한 쌍 a
     *        a + 3이 한 쌍 b
     *        b - 4가 한 쌍 c
     *        c - 5가 또 한 쌍 d
     *        d + 6 e
     *        e - 7 f
     *        f + 8 g
     *        최종 답 :: g
     *     3) 그 확인한 애들 기준으로 + 연산자 , - 연산자를 넣어서 계산을 한다.
     * **/
    // TODO :: 1+2+3-4-5+6-7+8를 입력받았다고 치고 코드를 짠다.
       /**TODO :: 첫 번째 미션 모든 연산자와 숫자를 분리하도록 한다. 분리하면 저장할 곳이 필요함. **/
       String inputStr = "23+34-45-56+67-78+89";
       String [] splitArray = new String[inputStr.length()];
       // TODO :: ["12","+","23","+"...]
       // TODO:: 연산자 왼쪽에 있는 값은 무조건 숫자 >>
       //      만약에 + 혹은 - 를 만나면 그 왼쪽에 있는 걸 arr에 넣는다.
       //      그 다음 while 조건이 length >> inputStr 에 아까 넣은 연산자 / 아까 넣은 숫자 마이너스 해버리면 length 가 줄어든다.
       //      "" 이게 될 때까지 반복
       int count = 0;

       while (inputStr.length()>0){
          if(inputStr.contains("+") || inputStr.contains("-")){
             // TODO :: indexOf는 없으면 -1을 반환한다.
             // TODO :: 무조건 뒤에 있게 만들기 위해서 조치 취함.
             if(Minus>Plus){
                String[] splitData = inputStr.split("\\+",2);
                String value = splitData[0];
                   splitArray[count] = value;
                   count++;
                String plus = "+";
                   splitArray[count] = plus;
                   count++;
                   inputStr = splitData[1];
                //-보다 플러스가 앞에 있다. 그러니까 연산자는 +
             }
             else {
                String[] splitData = inputStr.split("\\-",2);
                String value = splitData[0];
                splitArray[count] = value;
                count++;
                String minus = "-";
                splitArray[count] = minus;
                count++;
                inputStr = splitData[1];
                // -보다 플러스가 뒤에 있다. 그러니까 연산자는 -
             }
          }
          else{
             splitArray[count] = inputStr;
             inputStr = "";
          }
       }
       int sum = 0 ;
       for(int i = 0 ; i<splitArray.length; i++){
          if(splitArray[i]==null) break;
          if(splitArray[i].equals("+")){
             sum = Integer.parseInt(splitArray[i+1]) + sum;
             i++;
          }
          else if(splitArray[i].equals("-")){
             sum = sum- Integer.parseInt(splitArray[i+1]);
             i++;
          }
          else{
             sum = Integer.parseInt(splitArray[i]) + sum;
          }
       }	
}
