package Programmers.Lv0;

import java.util.Arrays;

public class Pgm120896 { // 한 번만 등장한 문자
    public String solution(String s) {
        String answer = "";
        String result = "";
        char [] ch = s.toCharArray();
        Arrays.sort(ch);
        answer = String.valueOf(ch);
        for (int i = 0; i < answer.length(); i++) {
            char temp = answer.charAt(i);
            int len = answer.length() - answer.replace(String.valueOf(temp), "").length();
            if(len == 1) result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Pgm120896 pg = new Pgm120896();
        String s = "hello";
        System.out.println(pg.solution(s));
    }
}
