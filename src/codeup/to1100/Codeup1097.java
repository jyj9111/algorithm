package codeup.to1100;

import java.util.Scanner;

public class Codeup1097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] goArr = new int[19][19];
        //입력
        for (int i = 0; i < goArr.length; i++) {
            for (int j = 0; j < goArr[i].length; j++) {
                goArr[i][j] = sc.nextInt();
            }
        }
        int cntNum = sc.nextInt();
        //처리
        for (int i = 0; i < cntNum; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            for (int j = 0; j < goArr.length; j++) {

                if(goArr[row][j] == 0) goArr[row][j] = 1;
                else goArr[row][j] = 0;

                if(goArr[j][col] == 0) goArr[j][col] = 1;
                else goArr[j][col] = 0;
            }
        }
        //출력
        for (int i = 0; i < goArr.length; i++) {
            for (int j = 0; j < goArr[i].length; j++) {
                System.out.printf("%d ", goArr[i][j]);
            }
            System.out.println();
        }
    }
}
