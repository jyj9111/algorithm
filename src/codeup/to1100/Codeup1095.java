package codeup.to1100;

import java.util.Arrays;
import java.util.Scanner;

public class Codeup1095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num ; i++) {
            int input = sc.nextInt();
            arr[i] = input;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
