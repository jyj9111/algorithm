package codeup.to1090;

import java.util.Scanner;

public class Codeup1087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            answer += i;
            if(answer >= num) {
                System.out.println(answer);
                break;
            }
        }
    }
}
