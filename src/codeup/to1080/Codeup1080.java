package codeup.to1080;

import java.util.Scanner;

public class Codeup1080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0, count = 0;

        for (int i = 1; sum < num ; i++) {
            sum += i;
            count++;
        }
        System.out.println(count);
    }
}
