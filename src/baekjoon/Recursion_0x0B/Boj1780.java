package baekjoon.Recursion_0x0B;

import java.io.*;

public class Boj1780 { //Boj 1780: 종이의 개수 (재귀)
    static int[][] paper;
    static int num;
    static int[] cnt = new int[3];

    static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x + n ; i++) {
            for (int j = y; j < y + n; j++) {
                if(paper[x][y] != paper[i][j])
                    return false;
            }
        }
        return true;
    }

    static void Paper(int x, int y, int z) {
        if(isSame(x, y, z)) {
            cnt[paper[x][y] + 1] += 1;
            return;
        }

        int n = z / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Paper(x + i * n, y + j * n, n);
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
        Paper(0, 0, num);

        for (int i = 0; i < cnt.length; i++) {
            bw.append(Integer.toString(cnt[i]) + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}