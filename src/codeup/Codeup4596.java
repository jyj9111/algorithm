package codeup;

import java.util.Scanner;

public class Codeup4596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        //입력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //처리
        int maxValue = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }
        //출력
        System.out.printf("%d\n", maxValue);
        System.out.printf("%d %d\n", maxRow, maxCol);
    }
}
