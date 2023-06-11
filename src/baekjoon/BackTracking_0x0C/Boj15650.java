package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj15650 { //Boj 15650: N과 M(2) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int nNum, mNum;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];

    static void func(int num) throws IOException {
        if(num == mNum) {
            for (int i = 0; i < mNum; i++) {
                bw.append(Integer.toString(arr[i]) + " ");
            }
            bw.append("\n");
            return;
        }
        int st = (num == 0) ? 1 : arr[num - 1] + 1;

        for (int i = st; i <= nNum; i++) {
            if(!isused[i]) {
                arr[num] = i;
                isused[i] = true;
                func(num + 1);
                isused[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);
        func(0);
        bw.flush();

        br.close();
        bw.close();
    }
}