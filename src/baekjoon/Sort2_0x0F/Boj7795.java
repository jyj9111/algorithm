package baekjoon.Sort2_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7795 { // Boj7795: 먹을 것인가 먹힐 것인가
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            StringTokenizer caseToken = new StringTokenizer(reader.readLine());
            int countA = Integer.parseInt(caseToken.nextToken());
            int countB = Integer.parseInt(caseToken.nextToken());

            int[] groupA = new int[countA + 1];
            int[] groupB = new int[countB + 1];

            caseToken = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= countA; j++) {
                groupA[j] = Integer.parseInt(caseToken.nextToken());
            }
            caseToken = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= countB; j++) {
                groupB[j] = Integer.parseInt(caseToken.nextToken());
            }

            Arrays.sort(groupB, 1, countB + 1);
            int result = 0;
            for (int j = 1; j <= countA; j++) {
                result += calculate(groupB, 1, countB, groupA[j]);
            }
            answer.append(result).append("\n");
        }

        reader.close();
        System.out.println(answer);
    }

    private int calculate(int[] arr, int st, int ed, int target) {
        int result = st - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] < target) {
                result = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        new Boj7795().solution();
    }
}
