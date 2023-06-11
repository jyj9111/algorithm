package codeup.to1090;

import java.util.Scanner;

public class Codeup1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = 1;
        double answer = 0;
        result *= sc.nextInt();
        result *= sc.nextInt();
        result *= sc.nextInt();
        result *= sc.nextInt();

        answer = result * 1.0 / 1024 / 1024 /8;
        System.out.printf("%.1f MB\n", answer);
    }
}
