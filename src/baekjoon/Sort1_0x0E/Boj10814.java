package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10814 { // Boj10814: 나이순 정렬

    public void solution() throws IOException {
        int[] countArr = new int[100001];
        Map<Integer, List<String>> userMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(reader.readLine());

        for (int i = 0; i < nNum; i++) {
            StringTokenizer userToken = new StringTokenizer(reader.readLine());
            int age = Integer.parseInt(userToken.nextToken());
            String name = userToken.nextToken();

            if (!userMap.containsKey(age)) {
                userMap.put(age, new ArrayList<>());
                userMap.get(age).add(name);
            } else {
                userMap.get(age).add(name);
            }

            countArr[age]++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                int age = i;
                for (int j = 0; j < countArr[i]; j++) {
                    String name = userMap.get(age).get(j);
                    answer.append(age).append(" ").append(name).append("\n");
                }
            }
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws IOException {
        new Boj10814().solution();
    }
}
