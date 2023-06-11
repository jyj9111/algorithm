package codeup.to1090;

import java.util.Scanner;

public class Codeup1089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stValue = sc.nextInt();
        int ebValue = sc.nextInt();
        int num = sc.nextInt();


        for (int i = 1; i < num; i++) {
            stValue += ebValue;
        }
        System.out.println(stValue);
    }
}
