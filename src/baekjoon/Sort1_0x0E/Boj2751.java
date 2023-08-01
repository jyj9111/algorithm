package baekjoon.Sort1_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2751 { // Boj2751: 수 정렬하기 2
    private int[] arr;
    private int[] temp;

    private void merge(int st, int ed) {
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

    public void mergeSort(int st, int ed) {
        if (ed == st + 1) return;
        int mid = (st + ed) / 2;
        mergeSort(st, mid);
        mergeSort(mid, ed);
        merge(st, ed);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nNum =  Integer.parseInt(reader.readLine());

        Boj2751 obj = new Boj2751();
        obj.arr =  new int[nNum];
        obj.temp =  new int[nNum];

        for (int i = 0; i < nNum; i++) {
            obj.arr[i] = Integer.parseInt(reader.readLine());
        }

        obj.mergeSort(0, nNum);

        StringBuilder answer = new StringBuilder();
        for (int i : obj.arr) {
            answer.append(i).append('\n');
        }
        System.out.println(answer);
    }
}
