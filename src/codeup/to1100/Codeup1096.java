package codeup.to1100;

import java.util.Scanner;

public class Codeup1096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntNum = sc.nextInt();
        int[][] goArr = new int[19][19];

        for (int i = 0; i < cntNum; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            goArr[row - 1][col - 1] = 1;
        }

        for (int i = 0; i < goArr.length; i++) {
            for (int j = 0; j < goArr[i].length; j++) {
                System.out.printf("%d ",goArr[i][j]);
            }
            System.out.println();
        }
    }
}
