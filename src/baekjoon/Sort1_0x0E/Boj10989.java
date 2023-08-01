package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10989 { // Boj10989: 수 정렬하기 3
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(reader.readLine());

        int[] countArr = new int[10001];

        for (int i = 0; i < nNum; i++) {
            int num = Integer.parseInt(reader.readLine());
            countArr[num]++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    answer.append(i).append('\n');
                }
            }
        }
        System.out.println(answer);
    }
}
