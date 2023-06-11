package codeup.to1030;

import java.util.Scanner;

public class Codeup1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] sNum = new int[5];
        for(int i = 0; i < 5; i++)
        {
            sNum[i] = num % 10;
            num = num/10;
        }
        System.out.println("[" + sNum[4] * 10000 + "]");
        System.out.println("[" + sNum[3] * 1000 + "]");
        System.out.println("[" + sNum[2] * 100 + "]");
        System.out.println("[" + sNum[1] * 10 + "]");
        System.out.println("[" + sNum[0] + "]");
    }
}
