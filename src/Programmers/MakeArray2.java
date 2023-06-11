package Programmers;

import java.util.Arrays;

public class MakeArray2 {
    public static boolean isZeroOrFive(int num) {
       int remainder = 0;
       while(num > 0) {
           remainder = num % 10;
           if(remainder % 5 != 0) {
                return false;
           }
           num /= 10;
       }
        return true;
    }
    public static int[] solution(int l, int r) {
        int[] answer = {};
        int[] result = new int[r - l];
        int count = 0;
        boolean check;
        for (int i = l; i <= r; i++) {
            check = isZeroOrFive(i);
            if(check) {
                result[count] = i;
                count++;
            }
        }
        if(count == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[count];
            for (int i = 0; i < count; i++) {
                answer[i] = result[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(10, 20);
        System.out.println(Arrays.toString(result));

    }
}
