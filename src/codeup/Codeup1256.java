package codeup;

import java.util.Scanner;

public class Codeup1256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        //.repeat()을 이용한 방법 java11 부터 가능
        // System.out.print("*".repeat(sc.nextInt()));
    }
}
