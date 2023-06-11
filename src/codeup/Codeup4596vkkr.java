package codeup;

import java.util.Scanner;

public class Codeup4596vkkr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //처리
        int maxValue = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int now = sc.nextInt();
                if(now > maxValue) {
                    maxValue = now;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        //출력
        System.out.printf("%d\n", maxValue);
        System.out.printf("%d %d\n", maxRow, maxCol);
    }
}
