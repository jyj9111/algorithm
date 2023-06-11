package codeup.to1100;

import java.util.Scanner;

public class Codeup1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력
        int wide = sc.nextInt();
        int height = sc.nextInt();
        int[][] arr = new int[wide][height];
        //처리
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int l = sc.nextInt(); // 4
            int d = sc.nextInt(); // 1
            int x = sc.nextInt(); // 2
            int y = sc.nextInt(); // 5
            int rangeX = 0;
            int rangeY = 0;
            if(x + l > height) {
                rangeY = height;
                if (d == 1) {
                    for (int j = x; j <= rangeY; j++) {
                        arr[j - 1][y - 1] = 1;
                    }
                } else {
                    for (int j = y; j < rangeX; j++) {
                        arr[x - 1][j - 1] = 1;
                    }
                }
            }
            else {
                rangeY = x + l;
                if (d == 1) {
                    for (int j = x; j < rangeY; j++) {
                        arr[j - 1][y - 1] = 1;
                    }
                } else {
                    for (int j = y; j < rangeX; j++) {
                        arr[x - 1][j - 1] = 1;
                    }
                }
            }
            if(y + l > wide) {
                rangeX = wide;
                if (d == 1) {
                    for (int j = x; j < rangeY; j++) {
                        arr[j - 1][y - 1] = 1;
                    }
                } else {
                    for (int j = y; j <= rangeX; j++) {
                        arr[x - 1][j - 1] = 1;
                    }
                }
            }
            else {
                rangeX = y + l;
                if (d == 1) {
                    for (int j = x; j < rangeY; j++) {
                        arr[j - 1][y - 1] = 1;
                    }
                } else {
                    for (int j = y; j < rangeX; j++) {
                        arr[x - 1][j - 1] = 1;
                    }
                }
            }


        }
        //출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
