package study.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 중위표기법 -> 후위표기법 변환
public class InfixToPostfix {

    private boolean isOperator(char token) {
        return true;
    }
    private int inStackPriority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed operator");
    }
    private int inComingPriority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed operator");
    }
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();

        // 연산자 담는 스택
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            // 연산자
            if (isOperator(token)) {
                // TODO 스택이 비어있다면 push (if)
                if (operStack.empty()) {
                    operStack.push(token);
                } else { // TODO 스택이 비지 않다면 (else if)
                    // TODO 스택의 제일 위의 연산자가 나보다 우선순위가 낮은 연산자가 올 때까지 pop (while)

                    while (inStackPriority(operStack.peek()) >= inComingPriority(token)) {
                        char top = operStack.peek();

                        answerBuilder.append(operStack.pop());
                        // TODO 순회 중 스택이 다 빌 경우 반복중단 (if break)
                        if (operStack.empty()) break;
                    }
                    // TODO 다 확인 while 종류 후 스택에 push
                    operStack.push(token);
                }

            } else if (token == ')') {  // 닫는 괄호일 때
                // TODO 스택에서 여는 괄호가 나올때까지 pop
                char top = operStack.pop();

                while (top != '(') {
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            // 숫자일 경우 바로 출력
            else answerBuilder.append(token);
        }

        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }

        System.out.println(answerBuilder);
    }
    public static void main(String[] args) throws IOException {
        new InfixToPostfix().solution();
    }
}
