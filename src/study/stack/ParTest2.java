package study.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest2 {
    public boolean solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        // 소, 중, 대 괄호로 이루어진 수식을 검사하는 코드를 작성하시오.

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);

            // 여는 괄호들을 만나면 stack에 push (대,중,소)
            if(next == '(') stack.push(next);
            else if(next == '{') stack.push(next);
            else if(next == '[') stack.push(next);

            // 닫는 괄호들을 만나면 (대,중,소)
            // 1. stack이 비어있는지 확인
            // 2. stack에서 꺼낸 괄호가 짝이 맞는 괄호인지 확인
            else if(next == ')') {
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp != '(') return false;
            }
            else if(next == '}') {
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp != '{') return false;
            }
            else if(next == ']') {
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp != '[') return false;
            }
        }
        // 순회를 다 마치고 stack이 비어있다면 true, 아니면 false
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest2().solution());
    }
}
