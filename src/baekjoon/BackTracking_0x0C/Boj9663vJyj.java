package baekjoon.BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9663vJyj { //Boj 9663: N-Queen (백트래킹)
    static int num;
    static int count = 0;

    static boolean[][] isPossible = new boolean[17][17];

    static void func(int value) {
        if(value == num) {
            count++;
            return;
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i == value || j == value)
                    continue;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
    }
}