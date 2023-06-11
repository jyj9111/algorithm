package codeup.to1100;

import java.util.Scanner;

public class Codeup1091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stValue = sc.nextInt();
        int eqValue = sc.nextInt();
        int ebValue = sc.nextInt();
        int num = sc.nextInt();
        long result = stValue;

        for (int i = 1; i < num; i++) {
            result = result * eqValue + ebValue ;
        }
        System.out.println(result);
    }
}
