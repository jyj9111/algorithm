package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj15651 { //Boj 15651: N과 M(3) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int nNum, mNum;
    static int[] arr = new int[10];

    static void func(int num) throws IOException {
        if(num == mNum) {
            for (int i = 0; i < mNum; i++) {
                bw.append(Integer.toString(arr[i]) + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = 1; i <= nNum; i++) {
            arr[num] = i;
            func(num + 1);
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