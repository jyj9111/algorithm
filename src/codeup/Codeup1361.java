package codeup;

import java.util.Scanner;

public class Codeup1361 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = "**";
        System.out.println(str);
        for (int i = 0; i < num - 1; i++) {
            str =" " + str;
            System.out.println(str);
        }
    }
}
