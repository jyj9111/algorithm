//소인수분해
//https://school.programmers.co.kr/learn/courses/30/lessons/120852
package Programmers;

import java.util.Arrays;

public class Prm120852 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12)));
    }

    public static int[] solution(int n) {
        int[] answer = {};
        int divisor = 2;
        int[] arr = new int[n + 1];

        while(n > 1) {
            if (n % divisor == 0) {
                arr[divisor] = divisor;
                n /= divisor;
            } else {
                divisor++;
            }
        }
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0)
                size++;
        }
        answer = new int[size];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}
