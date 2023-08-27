package baekjoon.DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2193 { // Boj2193 : 이친수
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[] dp = new long[n + 1];
        dp[1] = 1;
        if (n != 1)
         dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
    public static void main(String[] args) throws IOException {
        new Boj2193().solution();
    }
}
