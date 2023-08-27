package baekjoon.DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 { // Boj1003: 피보나치 함수
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());


        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int[][] dp = new int[41][2];
            dp[0] = new int[]{1, 0};
            dp[1] = new int[]{0, 1};

            int n = Integer.parseInt(reader.readLine());

            for (int j = 2; j <= n; j++) {
                dp[j][0] = dp[j - 2][0] + dp[j - 1][0];
                dp[j][1] = dp[j - 2][1] + dp[j - 1][1];
            }

            answer.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Boj1003().solution();
    }
}
