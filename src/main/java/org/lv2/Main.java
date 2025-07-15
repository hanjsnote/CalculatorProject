package org.lv2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        char operator;

        Calculator cal = new Calculator();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            cal.firstNum = sc.nextLine();

            try {
                String st = cal.firstNum;
                if(cal.positiveValidation(Integer.parseInt(st))){  //음수면 continue 수행
                    continue;
                }
                cal.firstNum = st; //통과한 값 저장
            } catch (NumberFormatException e){  //정수 아닌값 입력하면 continue 수행
                System.out.println("정수만 입력 가능합니다. 다시 입력해주세요");
                continue;
            }

            while(true){
                System.out.print("두 번째 숫자를 입력하세요: ");
                cal.secondNum = sc.nextLine();
                try {
                    String st = cal.secondNum;
                    if (cal.positiveValidation(Integer.parseInt(st))) {   //음수면 continue 수행
                        continue;
                    }
                    cal.secondNum = st;
                    break;
                } catch(NumberFormatException e){   //정수 아닌값 입력하면 다시 while(true)수행
                    System.out.println("정수만 입력 가능합니다. 다시 입력해주세요");
                }
            }

            while (true){
                System.out.print("연산자(사칙연산 기호 +, -, * , /)를 입력하세요: ");
                operator = sc.next().charAt(0);
                if(cal.operatorValidation(operator)){  //입력값이 +,-,*,/ 아니면
                    continue;                          //메서드에서 true를 반환받아 continue 수행하고
                }
                break;                               //break를 건너뛰어 해당 루프를 탈출하지 않고 다시 반복
            }                                        //false면 break로 해당 루프 탈출

            int result = 0;
            switch(operator){
                case '+':
                    result = cal.sum(Integer.parseInt(cal.firstNum), Integer.parseInt(cal.secondNum));
                    break;
                case '-':
                    result = cal.sub(Integer.parseInt(cal.firstNum), Integer.parseInt(cal.secondNum));
                    break;
                case '*':
                    result = cal.mul(Integer.parseInt(cal.firstNum), Integer.parseInt(cal.secondNum));
                    break;
                case '/':
                    if(Integer.parseInt(cal.secondNum) == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = cal.div(Integer.parseInt(cal.firstNum), Integer.parseInt(cal.secondNum));
                        break;
                    }
            }

            System.out.println("결과: " + cal.firstNum + " " + operator + " " + cal.secondNum + " = " + result);


            //Setter
            while (true) {
                System.out.print("현재 List에 들어 있는 값: " + cal.getListResult() + "입니다. 수정하시겠습니까? (y,n): ");
                char inputList = sc.next().charAt(0);
                sc.nextLine();     //버퍼 비우기

                if(cal.modifyListValidation(inputList)) //입력값이 y(수정), n(수정안함)이 아니면 반복
                    continue;
                if (inputList == 'y') {
                    while (true) {
                        System.out.print("index value 수정 (예: 0번째 인덱스의 값을 5로 바꾸려면 0 5 입력) 또는 삭제하려면 x 입력 : ");
                        String modifyList = sc.nextLine();

                        String[] parts = modifyList.split(" "); //2 5로 입력 받기에 String으로 받아서 split()후 정수로 변환
                        if (parts.length == 2) {
                            int index = Integer.parseInt(parts[0]);  //parts 배열의 0번째에 index를 저장
                            int value = Integer.parseInt(parts[1]);  //parts 배열의 1번째에 수정할 value값 저장
                            if (cal.modifyIndexValidation(index)) { //잘못된 인덱스값 입력하면 반복
                                continue;
                            }
                            cal.setListResult(index, value);    //setListResult에 key, value값을 넘겨줌
                            System.out.println("수정 완료! 현재 리스트의 값: " + cal.getListResult());
                            break;
                        } else if(modifyList.equals("x")){  //x 입력시 리스트의 첫 번째 값 삭제
                            cal.removeResult();
                            System.out.println("삭제 완료! 현재 리스트의 남아 있는 값 : " + cal.getListResult());
                            break;
                        } else {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); //0 10 10 이런식으로 입력하면 다시 반복
                        }
                    }

                } else if (inputList == 'n') {
                    break;
                }
            }

            while(true) {
                System.out.print("더 계산하시겠습니까? 계속 하려면 엔터키 또는 \"exit\" 입력 시 종료: ");
                String exitStr = sc.nextLine();
                if (exitStr.equals("exit")) {   //종료
                    System.out.println("\nGood bye~");
                    return;
                }
                if(cal.exitValidation(exitStr)) {   //
                    break;
                }
            }
        }
    }
}