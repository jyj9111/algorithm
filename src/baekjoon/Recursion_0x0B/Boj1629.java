package baekjoon.Recursion_0x0B;

import java.util.Scanner;

public class Boj1629 { //Boj 1629: 곱셈 (재귀)
    public long Pow (int num1, int num2, int mod) {
        if(num2 == 1)                               // 종료조건 :
            return num1 % mod;
        long value = Pow(num1, num2 / 2, mod);
        value = value * value % mod;
        if(num2 % 2 == 0)
            return value;
        return value * num1 % mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int mod = sc.nextInt();
        Boj1629 sd = new Boj1629();
        System.out.print(sd.Pow(num1, num2, mod));
    }
}