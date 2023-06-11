package codeup.to1030;

import java.util.Scanner;

public class Codeup1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");

        for (int i = 0; i < str.length; i++){
            System.out.println("\'" + str[i] + "\'");
        }
    }
}
