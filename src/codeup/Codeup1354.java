package codeup;

import java.util.Scanner;

public class Codeup1354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = num; i > 0; i--) {
            String str = "";
            for (int j = 0; j < i; j++) {
                str += "*";
            }
            System.out.println(str);
        }
    }
}
