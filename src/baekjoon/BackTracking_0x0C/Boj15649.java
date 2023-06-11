package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj15649 { //Boj 15649: N과 M(1) (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int num1, num2;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];

    static void func(int num) throws IOException {
        if(num == num2) {
            for (int i = 0; i < num2; i++) {
                bw.append(Integer.toString(arr[i]) + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = 1; i <= num1; i++) {
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
        num1 = Integer.parseInt(input[0]);
        num2 = Integer.parseInt(input[1]);
        func(0);
        bw.flush();

        br.close();
        bw.close();
    }
}