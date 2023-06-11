package codeup.to1100;

import java.util.Scanner;

public class Codeup1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int day = 1;
        while(day % num1 != 0 || day % num2 != 0 || day % num3 != 0) day++;

        System.out.println(day);
    }
}
