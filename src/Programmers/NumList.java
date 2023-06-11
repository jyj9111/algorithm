package Programmers;

public class NumList {
    public static int solution (int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                even += Integer.toString(num_list[i]);
            } else {
                odd += Integer.toString(num_list[i]);
            }
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even);
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
