package codeup.to1060;

import java.util.Scanner;

public class Codeup1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1 <= num2)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
