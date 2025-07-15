package org.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int firstNum = 0;
        int secondNum = 0;

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("첫 번째 숫자를 입력해 주세요: ");
            firstNum = sc.nextInt();

            if(firstNum < 0){       //첫 번째 수 유효성 검사
                System.out.println("양수가 아닙니다.");
                continue;
            }

            while(true){        //두 번째 수 유효성 검사
                System.out.print("두 번째 숫자를 입력해 주세요: ");
                secondNum = sc.nextInt();

                if(secondNum < 0) {
                    System.out.println("양수가 아닙니다.");
                    continue;
                }
                break;
            }

            System.out.print("연산자(사칙연산 기호 +, -, * , /)를 입력해주세요: ");
            char operator = sc.next().charAt(0);

            int result = 0;
            switch(operator){
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if(secondNum == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = firstNum / secondNum;
                        break;
                    }
            }
            System.out.println("결과: " + firstNum + " " + operator + " " + secondNum + " = " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            sc.nextLine();          //Enter(\n)를 읽지 않아서 버퍼에 남아 있는 '\n'을 nextLine()으로 제거하고 exit = nextLine() 수행
            String exitStr = sc.nextLine();
            if(exitStr.equals("exit")){
                System.out.println("Good bye~");
                break;
            }
        }
    }
}
