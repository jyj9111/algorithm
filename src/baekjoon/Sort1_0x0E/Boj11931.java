package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11931 { // Boj11931: 수 정렬하기 4
    private int[] arr = new int[2000001];
    private int stIdx = 1000000;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < nNum; i++) {
            int num = Integer.parseInt(reader.readLine());
            arr[stIdx + num]++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] != 0)
                answer.append(i - stIdx).append('\n');
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws IOException {
        new Boj11931().solution();
    }
}
