package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11728 { // Boj11728: 배열 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        int aSize = Integer.parseInt(info.nextToken());
        int bSize = Integer.parseInt(info.nextToken());

        int[] aArray = new int[aSize];
        StringTokenizer numberToken = new StringTokenizer(reader.readLine());
        for (int i = 0; i < aSize; i++) {
            aArray[i] = Integer.parseInt(numberToken.nextToken());
        }

        int[] bArray = new int[bSize];
        numberToken = new StringTokenizer(reader.readLine());
        for (int i = 0; i < bSize; i++) {
            bArray[i] = Integer.parseInt(numberToken.nextToken());
        }

        int[] answer = new int[aSize + bSize];

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < aSize + bSize; i++) {
            if (bIdx == bSize) answer[i] = aArray[aIdx++];
            else if (aIdx == aSize) answer[i] = bArray[bIdx++];
            else if (aArray[aIdx] <= bArray[bIdx]) answer[i] = aArray[aIdx++];
            else answer[i] = bArray[bIdx++];
        }
        StringBuilder result = new StringBuilder();
        for (int i : answer)
            result.append(i).append(" ");
        System.out.println(result);
    }
}
