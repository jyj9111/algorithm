package baekjoon.Recursion_0x0B;

import java.io.*;

public class Boj11729 { //Boj 11729: 하노이 탑 이동 순서 (재귀)
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void FuncHanoi (int stColumn, int edColumn, int n ) throws IOException {

        if(n == 1) {
            bw.append(Integer.toString(stColumn) + " ");
            bw.append(Integer.toString(edColumn) + "\n");
            return;
        }
        FuncHanoi(stColumn, 6 - stColumn - edColumn, n - 1);
        bw.append(Integer.toString(stColumn) + " ");
        bw.append(Integer.toString(edColumn) + "\n");
        FuncHanoi(6 - stColumn - edColumn, edColumn, n - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Boj11729 sd = new Boj11729();

        sd.bw.append(Integer.toString((1 << num) - 1) + "\n");
        sd.FuncHanoi(1, 3, num);
        sd.bw.flush();
    }
}