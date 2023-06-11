package Programmers;

import java.util.Arrays;

public class Programmers181924 {
    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int [] qur = new int[2];
        int temp = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[i].length; j++) {
                qur[j] = queries[i][j];
            }
            temp = arr[qur[0]];
            arr[qur[0]] = arr[qur[1]];
            arr[qur[1]] = temp;
        }
        answer = arr;
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3},{1, 2},{1, 4}};

        int[] result = solution(arr, queries);
        System.out.println(Arrays.toString(result));
    }
}
