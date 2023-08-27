package baekjoon.DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 { // Boj1463: 1로 만들기
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(reader.readLine());

        int[]dp = new int[nNum + 1];
        dp[1] = 0;
        for (int i = 2; i <= nNum; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[nNum]);
    }
    public static void main(String[] args) throws IOException {
        new Boj1463().solution();
    }
}
