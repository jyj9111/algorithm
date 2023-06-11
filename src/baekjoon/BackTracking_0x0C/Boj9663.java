package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj9663 { //Boj 9663: N-Queen (백트래킹)
    static int num;
    static int count = 0;

    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];

    static void func(int curr) {
        if(curr == num) {
            count++;
            return;
        }

        for (int i = 0; i < num; i++) {
            if (isused1[i] || isused2[i + curr] || isused3[curr - i + num - 1]) {
                continue;
            }
            isused1[i] = true;
            isused2[curr + i] = true;
            isused3[curr - i + num - 1] = true;
            func(curr + 1);
            isused1[i] = false;
            isused2[curr + i] = false;
            isused3[curr - i + num - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        func(0);
        bw.append(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}