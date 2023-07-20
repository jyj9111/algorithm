package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14888 { //Boj14888: 연산자 끼워넣기
    static int[] nums;
    static int[] index;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] isUsed;
    static List<String> operators = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        receiveInput();
        pickOperator(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void pickOperator(int num) {
        if(num == operators.size()) {
            solution(index);
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if(!isUsed[i]) {
                index[num] = i;
                isUsed[i] = true;
                pickOperator(num + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void solution(int[] arr) {
        Queue<Integer> number = new LinkedList<>();
        for(int num : nums) {
            number.add(num);
        }

        Queue<String> oper = new LinkedList<>();
        for(int idx : arr) {
            oper.add(operators.get(idx));
        }

        int sum = number.poll();

        while(!oper.isEmpty()) {
            int crr = number.poll();
            String op = oper.poll();

            if(op.equals("+")) sum += crr;
            else if(op.equals("-")) sum -= crr;
            else if(op.equals("*")) sum *= crr;
            else {
                if(sum < 0) sum = -(Math.abs(sum) / crr);
                else sum /= crr;
            }
        }

        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nNum = Integer.parseInt(br.readLine());
        nums = new int[nNum];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            String temp = input[i];
            for (int j = 0; j < Integer.parseInt(temp); j++) {
                if(i == 0) operators.add("+");
                else if(i == 1) operators.add("-");
                else if(i == 2) operators.add("*");
                else operators.add("/");
            }
        }
        index = new int[operators.size()];
        isUsed = new boolean[operators.size()];
    }
}
