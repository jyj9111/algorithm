package baekjoon.BackTracking_0x0C;

import java.io.*;

public class Boj1182 { //Boj 1182: 부분수열의 합 (백트래킹)
    static int nNum;
    static int sNum;
    static int[] arr;

    static int count = 0;

    static void func(int curr) {
        // baseline: 부분수열의 수 만큼 재귀
        if(curr == (1 << nNum)) { // 1 << nNum = 부분수열의 개수를 나타내는 식
            return;
        }
        int result = 0; // 부분수열 원소의 합을 저장하기 위한 변수

        for (int i = 0; i < nNum; i++) {
            if((curr & 1 << i) != 0) // 각 부분수열의 원소를 구하는 로직
                result += arr[i];
        }

        if(result == sNum) // 부분수열 원소의 합과 두번째 입력된 숫자 sNum과 비교 하여 같으면 count
            count++;

        func(curr + 1); // 반복
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        sNum = Integer.parseInt(input[1]);

        arr = new int[nNum];

        String[] intput2 = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            arr[i] = Integer.parseInt(intput2[i]);
        }

        func(1);
        bw.append(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}