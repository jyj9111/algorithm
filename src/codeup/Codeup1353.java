package codeup;

import java.util.Scanner;

public class Codeup1353 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = "";
        for (int i = 0; i < num; i++) {
            str += "*";
            System.out.println(str);
        }
    }
}
