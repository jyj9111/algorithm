package codeup.to1090;

import java.util.Scanner;

public class Codeup1086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = 1;
        double answer = 0;
        result *= sc.nextInt(); //w
        result *= sc.nextInt(); //h
        result *= sc.nextInt(); //b

        answer = result * 1.0 / 1024 / 1024 / 8;
        System.out.printf("%.2f MB\n", answer);
    }
}
