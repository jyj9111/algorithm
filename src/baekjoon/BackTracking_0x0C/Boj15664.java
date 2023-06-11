package baekjoon.BackTracking_0x0C;

import java.io.*;
import java.util.Arrays;

public class Boj15664 { //Boj 15664: N과 M(10) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int nNum, mNum;
    static int[] arr;
    static int[] ansArr;


    static void func(int num, int st) throws IOException {
        if(num == mNum) {
            for (int i = 0; i < mNum; i++) {
                bw.append((ansArr[i]) + " ");
            }
            bw.append("\n");
            return;
        }
        int temp = 0;

        for (int i = st; i < nNum; i++) {
            if(temp != arr[i]) {
                ansArr[num] = arr[i];
                temp = ansArr[num];
                func(num + 1, i + 1);
            }
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

        func(0, 0);

        bw.flush();

        br.close();
        bw.close();
    }
}