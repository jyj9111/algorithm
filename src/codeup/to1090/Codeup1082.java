package codeup.to1090;

import java.util.Scanner;

public class Codeup1082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oxNum = Integer.parseInt(sc.nextLine(), 16);
        for (int i = 0x01; i <= 0x0F; i++) {
            System.out.printf("%X*%X=%X\n", oxNum, i, oxNum * i);
        }
    }
}
