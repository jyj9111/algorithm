package study.stack;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest {
    public boolean solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> charStack = new Stack<>();

        // 1. 여는 괄호를 만날때 push
        // 2. 단는 괄호를 만날 경우
        //  2-1. pop 할게 없으면 검사 실패 (false 반환)
        //  2-2. 아니라면 pop
        //  2-3. pop의 결과로 나온 값이 여는 괄호인지 확인
        // 3. 순회가 끝났을 때 스택이 비어있는지 확인
        //  3-1. 비었으면 true, 안비었으면 false 반환
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);
            if(next == '(') {
                charStack.push(next);
            } else if (next == ')') {
                if(charStack.isEmpty()) return false;
                char top = charStack.pop();
                if(top != '(') return false;
            }
        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest().solution());
    }
}
