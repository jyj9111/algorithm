package baekjoon.BackTracking_0x0C;

import java.io.*;
import java.util.Arrays;

public class Boj15656 { //Boj 15656: N과 M(7) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int nNum, mNum;
    static int[] arr;
    static int[] ansArr;

    static void func(int num) throws IOException {
        if(num == mNum) {
            for (int i = 0; i < mNum; i++) {
                bw.append((arr[ansArr[i]]) + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = 0; i < nNum; i++) {
            ansArr[num] = i;
            func(num + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        arr = new int[nNum];
        ansArr = new int[nNum];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);

        func(0);

        bw.flush();

        br.close();
        bw.close();
    }
}