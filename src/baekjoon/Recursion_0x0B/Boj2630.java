package baekjoon.Recursion_0x0B;

import java.io.*;

public class Boj2630 { //Boj 2630: 색종이 만들기 (재귀)
    static int[][] paper;
    static int num;
    static int[] cnt = new int[2];

    static boolean isSame(int x, int y, int num) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if(paper[x][y] != paper[i][j])
                    return false;
            }
        }
        return true;
    }

    static void solve(int x, int y, int num) {
        if(isSame(x, y, num)) {
            cnt[paper[x][y]]++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + i * num /2, y + j * num /2, num / 2);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        paper = new int[num][num];

        for (int i = 0; i < num; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                paper[i][j] = Integer.parseInt(split[j]);
            }
        }
        solve(0, 0, num);

        for (int i = 0; i < cnt.length; i++) {
            bw.append(Integer.toString(cnt[i]) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}