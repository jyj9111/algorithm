package baekjoon.Sort2_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj2910 { // Boj2910: 빈도 정렬
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int nNum = Integer.parseInt(infoToken.nextToken());
        int cNum = Integer.parseInt(infoToken.nextToken());

        HashMap<Integer, Integer> numberMap =  new LinkedHashMap<>();
        infoToken = new StringTokenizer(reader.readLine());

        for (int i = 0; i < nNum; i++) {
            int num = Integer.parseInt(infoToken.nextToken());
            numberMap.put(num,numberMap.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> numberSet = numberMap.entrySet();
        numberSet = numberSet.stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // 출력
        StringBuilder answer = new StringBuilder();
        numberSet.forEach(o -> {
            for (int i = 0; i < o.getValue(); i++) {
                answer.append(o.getKey()).append(" ");
            }
        });
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        new Boj2910().solution();
    }
}
