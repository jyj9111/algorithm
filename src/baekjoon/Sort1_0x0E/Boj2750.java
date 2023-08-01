package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2750 { // Boj2750: 수 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum =  Integer.parseInt(reader.readLine());

        int[] arr =  new int[nNum];
        for (int i = 0; i < nNum; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder();
        for (int i : arr) {
            answer.append(i).append('\n');
        }
        System.out.println(answer);
    }
}
