package baekjoon.Sort2_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1181 { // Boj1181: 단어 정렬
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(reader.readLine());

        Map<Integer, List<String >> words = new HashMap<>();
        for (int i = 1; i <= 50; i++) {
            words.put(i, new ArrayList<>());
        }

        int[] countArr = new int[51];
        for (int i = 0; i < nNum; i++) {
            String word = reader.readLine();
            int key = word.length();
            if (!words.get(key).contains(word)) {
                words.get(key).add(word);
                countArr[key]++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                Collections.sort(words.get(i));
                for (int j = 0; j < countArr[i]; j++) {
                    answer.append(words.get(i).get(j)).append('\n');
                }
            }
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        new Boj1181().solution();
    }
}
