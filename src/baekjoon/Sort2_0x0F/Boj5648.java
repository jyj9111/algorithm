package baekjoon.Sort2_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj5648 { // Boj5648: 역원소 정렬
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());

        int nNum = Integer.parseInt(infoToken.nextToken());
        int count = infoToken.countTokens();
        long[] arr = new long[nNum];
        for (int i = 0; i < count; i++) {
            arr[i] = reverseElement(infoToken.nextToken());
        }

        while (true) {
            if (count == nNum) break;

            infoToken = new StringTokenizer(reader.readLine());
            int numCount = infoToken.countTokens();
            for (int i = 0; i < numCount; i++) {
                arr[count++] = reverseElement(infoToken.nextToken());
            }
        }

        radixSort(arr);

        StringBuilder answer = new StringBuilder();
        for (long i : arr) {
            answer.append(i).append("\n");
        }
        System.out.print(answer);
    }

    private void radixSort(long[] arr) {
        List<Long>[] list = new List[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        int n = 10;

        for (int i = 0; i < 13; i++) {
            for (long x : arr) {
                list[(int) x % n / (n / 10)].add(x);
            }

            int cnt = 0;

            for (List<Long> x : list) {
                for (long y : x) {
                    arr[cnt++] = y;
                }
                x.clear();
            }
            n = n * 10;
        }
    }


    private long reverseElement(String element) {
        char[] chElement = element.toCharArray();
        String result = "";
        for (int i = 0; i < chElement.length; i++) {
            result += chElement[chElement.length - i - 1];
        }
        return Long.parseLong(result);
    }

/*    private void merge(int st, int ed, long[] arr) {
        long[] temp = new long[arr.length];
        int mid = (st + ed) / 2;
        int leftIdx = st;
        int rightIdx = mid;

        for (int i = st; i < ed; i++) {
            if (rightIdx == ed) temp[i] = arr[leftIdx++];
            else if (leftIdx == mid) temp[i] = arr[rightIdx++];
            else if (arr[leftIdx] <= arr[rightIdx]) temp[i] = arr[leftIdx++];
            else temp[i] = arr[rightIdx++];
        }

        for (int i = st; i < ed; i++) {
            arr[i] = temp[i];
        }
    }

    private void mergeSort(int st, int ed, long[] arr) {
        if (ed == st + 1) return;
        int mid = (st + ed) / 2;

        mergeSort(0, mid, arr);
        mergeSort(mid, ed, arr);
        merge(st, ed, arr);
    }*/

    public static void main(String[] args) throws IOException {
        new Boj5648().solution();
    }
}
