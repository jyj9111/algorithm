package baekjoon.BackTracking_0x0C;

import java.io.*;
import java.util.Arrays;

public class Boj15654 { //Boj 15654: N과 M(5) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int nNum, mNum;
    static int[] arr;
    static int[] ansArr;
    static boolean[] isUsed;

    static void func(int num) throws IOException {
        if(num == mNum) {
            for (int i = 0; i < mNum; i++) {
                bw.append((ansArr[i]) + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = 1; i <= nNum; i++) {
            if(!isUsed[i]) {
                ansArr[num] = arr[i];
                isUsed[i] = true;
                func(num + 1);
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        arr = new int[nNum + 1];
        ansArr = new int[nNum + 1];
        isUsed = new boolean[nNum + 1];

        String[] input2 = br.readLine().split(" ");
        for (int i = 1; i <= nNum; i++) {
            arr[i] = Integer.parseInt(input2[i - 1]);
        }
        Arrays.sort(arr);

        func(0);

        bw.flush();

        br.close();
        bw.close();
    }
}