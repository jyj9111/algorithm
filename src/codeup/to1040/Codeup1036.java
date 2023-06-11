package codeup.to1040;

import java.util.Scanner;

public class Codeup1036 {
    public static void main(String[] args) {
        // 영문자 1개 입력 > 10진수 출력 (ASCII 코드값)
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.println((int)ch);
    }
}
