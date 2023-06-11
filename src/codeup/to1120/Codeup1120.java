package codeup.to1120;

import java.util.Scanner;

public class Codeup1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        float result = ((float)num1 + (float)num2 + (float)num3) / 3;

        System.out.printf("%.2f\n", result);
    }
}
