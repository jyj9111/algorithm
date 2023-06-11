package baekjoon.Recursion_0x0B;

import java.io.*;


public class Boj1074 { //Boj 1074: Z (재귀)
    static int FuncZ(int n, int r, int c) {
        if(n == 0)
            return 0;
        int half = 1 << (n - 1); // N / 2 와 같은 식
        if(r < half && c < half) // 종이를 4등분 했을 때 2사분면(왼쪽 위)
            return FuncZ(n - 1, r, c);
        if(r <  half && c >= half) // 종이를 4등분 했을 때 1사분면(오른쪽 위)
            return half * half + FuncZ(n - 1, r, c - half);
        if(r >= half && c < half) // 종이를 4등분 했을 때 3사분면(왼쪽 아래)
            return 2 * half * half + FuncZ(n - 1, r - half, c);
        // 종이를 4등분 했을 때 4사분면(오른쪽 아래)
        return 3 * half * half + FuncZ(n - 1, r - half, c - half);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int row = Integer.parseInt(input[1]);
        int column = Integer.parseInt(input[2]);

        int result = FuncZ(num, row, column);

        bw.append(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}