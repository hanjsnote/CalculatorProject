package org.lv2;

import java.util.*;

public class Calculator {

    private final List<Integer> listResult = new ArrayList<Integer>();

    String firstNum;
    String secondNum;
    int result = 0;

    public int sum(int firstNum, int secondNum){    //덧셈!
        result = firstNum + secondNum;
        listResult.add(result);
        return result;
    }
    public int sub(int firstNum, int secondNum){    //뺄셈!
        result = firstNum - secondNum;
        listResult.add(result);
        return result;
    }
    public int mul(int firstNum, int secondNum){    //곱하기!
        result = firstNum * secondNum;
        listResult.add(result);
        return result;
    }
    public int div(int firstNum, int secondNum){    //나누기!
        result = firstNum / secondNum;
        listResult.add(result);
        return result;
    }

    //Getter 메서드 구현
    public List<Integer> getListResult() {
        return listResult;
    }
    //Setter 메서드 구현
    public void setListResult(int index, int value){   //index는 key, value는 값
        listResult.set(index, value);
    }
    //리스트의 첫 번째 값 제거 메서드
    public void removeResult(){
        listResult.remove(0);
    }


    //유효성 검사 메서드
    //음수 판별 입력값 검사
    public boolean positiveValidation (int num){
        if(num < 0) {
            System.out.println("양수가 아닙니다.");
            return true; //양수가 아니면 true 반환 continue 수행
        } else {
            return false;
        }
    }

    //연산자 입력값 검사
    public boolean operatorValidation (char op){
        if(op != '+' && op != '-' && op != '*' && op != '/'){
            System.out.println("연산자 +, -, *, / 중 하나만 입력하세요");
            return true;
        }
        return false;
    }

    //List 수정여부 입력값 검사
    public boolean modifyListValidation (char ch){
        if(ch == 'y' || ch == 'n'){
            return false;
        } else {
            System.out.println("y 또는 n만 유효합니다. 다시 입력해 주세요: ");
            return true;
        }
    }

    //List 수정 index범위 입력값 검사
    public boolean modifyIndexValidation (int index){
        if(index < 0 || index >= listResult.size()) { //list에 들어 있는 인덱스길이를 초과해서 입력하면 다시 입력
            System.out.println("IndexOutOfBoundsException!! 다시 입력해 주세요. ");
            return true;
        }
        return false;
    }

    //exit 엔터 입력값 검사
    public boolean exitValidation (String exit){
        if(!exit.isEmpty() && !exit.equals("exit")){    //입력이 엔터 또는 exit가 아니면
            System.out.println("엔터 또는 exit만 입력해주세요");
            return false;                               //false를 반환하여 break를 건너뛰고 해당 while문 반복
        }
        return true;                                //true면 해당 while문 탈출 상위 루프로 이동
    }

}