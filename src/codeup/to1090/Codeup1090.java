package codeup.to1090;

import java.util.Scanner;

public class Codeup1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stValue = sc.nextInt();
        int eqValue = sc.nextInt();
        int num = sc.nextInt();
        long result = stValue;

        for (int i = 1; i < num; i++) {
            result *= eqValue;
        }
        System.out.println(result);
    }
}
