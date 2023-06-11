package codeup;

import java.util.Scanner;

public class Codeup1367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = "";
        for (int i = 0; i < num; i++) {
            str += "*";
        }
        for (int i = num; i > 0; i--) {
            String temp = str;
            for (int j = 0; j < i - 1; j++) {
                temp = " " + temp;
            }
            System.out.println(temp);
        }
    }
}
