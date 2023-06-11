package codeup.to1080;

import java.util.Scanner;

public class Codeup1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char data = sc.next().charAt(0);
        for (int i = 0; data != 'q'; i++) {
            System.out.println(data);
            data = sc.next().charAt(0);
        }
        System.out.println(data);
    }
}
