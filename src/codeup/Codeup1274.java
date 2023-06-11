package codeup;

import java.util.Scanner;

public class Codeup1274 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fCount = 0;

        for (int i = 2; i < num; i++) {
            if(num % i == 0) fCount++;
        }
        if(fCount == 0) System.out.println("prime");
        else System.out.println("not prime");
    }
}
