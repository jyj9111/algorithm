package codeup.to1040;

import java.util.Scanner;

public class Codeup1035 {
    public static void main(String[] args) {
        // 16진수 입력 > 8진수 출력
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt(16);
        System.out.printf("%o",in);
    }
}
