package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj6603 { //Boj 6603: 로또 (백트래킹)
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int kNum;
    static int[] arr = new int[15];
    static int[] answer = new int[15];
    static boolean[] isUsed =new boolean[15];

    static void func(int num, int st) throws IOException {
        if(num == 6) {
            for (int i = 0; i < 6; i++) {
                bw.append(answer[i] + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = st; i < kNum; i++) {
            if(!isUsed[i]) {
                answer[num] = arr[i];
                isUsed[i] = true;
                func(num + 1, i + 1);
                isUsed[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("0")) break;

            kNum = Integer.parseInt(split[0]);

            for (int i = 0; i < kNum; i++) {
                arr[i] = Integer.parseInt(split[i + 1]);
            }

            func(0, 0);
            bw.append("\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }
}
