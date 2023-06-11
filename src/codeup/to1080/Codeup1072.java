package codeup.to1080;

import java.util.Scanner;

public class Codeup1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[]arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }
    }
}
