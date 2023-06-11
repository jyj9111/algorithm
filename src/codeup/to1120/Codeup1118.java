package codeup.to1120;

import java.util.Scanner;

public class Codeup1118 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int base = sc.nextInt();
        int height = sc.nextInt();

        System.out.printf("%.1f\n", base * height * 0.5);
    }
}
