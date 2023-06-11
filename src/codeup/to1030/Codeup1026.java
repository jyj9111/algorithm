package codeup.to1030;

import java.util.Scanner;

public class Codeup1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(":");
        System.out.printf("%d", Integer.parseInt(split[1]));
    }
}
