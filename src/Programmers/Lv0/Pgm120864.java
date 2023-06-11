package Programmers.Lv0;

import java.util.Arrays;

public class Pgm120864 { // 숨어있는 숫자의 덧셈(2)
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-zA-Z]", "-");
        String[] split = my_string.split("-");
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals(""))continue;
            answer += Integer.parseInt(split[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Pgm120864 pg = new Pgm120864();
        String str = "aAb1B2cC34oOp";
        System.out.println(pg.solution(str));
    }
}
