package codeup;

import java.util.Scanner;

public class Codeup1273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int[] result = new int[num];
        for (int i = 1; i <= num; i++) {
            if(num % i == 0) {
                result[count] = i;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
