package codeup.to1040;

import java.util.Scanner;

public class Codeup1033 {
    public static void main(String[] args) {
        // 10진수 입력 > 16진수 출력 (대문자)
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        System.out.printf("%X",in);
    }
}
