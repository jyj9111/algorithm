package baekjoon.DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 { // Boj1932: 정수 삼각형
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(reader.readLine());

        int[][] dp = new int[n + 2][n + 2];
        dp[1][1] = Integer.parseInt(reader.readLine());

        for (int i = 2; i <= n; i++) {
            String[] split = reader.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                int maxNum = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] = maxNum + Integer.parseInt(split[j - 1]);
            }
        }
        int max = -1;
        for (int i : dp[n]) {
            max = Math.max(max, i);
        }
        System.out.print(max);
    }
    public static void main(String[] args) throws IOException {
        new Boj1932().solution();
    }
}
