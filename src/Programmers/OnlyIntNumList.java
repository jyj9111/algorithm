package Programmers;

public class OnlyIntNumList {
    public static int solution(int[] num_list) {
        int answer = 0;
        int[] odd = new int[num_list.length];
        int[] even = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++) {
            if ( num_list[i] % 2 == 0) {
                even[i] = num_list[i];
            } else {
                odd[i] = num_list[i];
            }
        }
        for (int i = odd.length - 1; i > 0 ; i--) {
            answer += odd[i] * Math.pow(10, i);
        }
        for (int i = even.length - 1; i > 0 ; i--) {
            answer += even[i] * Math.pow(10, i);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2, 1};
        int[] arr2 = {5, 7, 8, 3};

        int result = solution(arr);
        int result2 = solution(arr2);

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }
}
