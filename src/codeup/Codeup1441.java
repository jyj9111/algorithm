package codeup;

import java.util.Scanner;

public class Codeup1441 {
    public static void main(String[] args) {

        // 버블정렬 문제
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int [10001];
        int i, j, temp = 0;

        for( i = 1; i <= num; i++) {
            arr[i] = sc.nextInt();
        }

        for ( i = 1; i < num; i++) {
            for ( j = 1; j < num; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for ( i = 1; i <= num; i++) {
            System.out.println(arr[i]);
        }
    }
}
