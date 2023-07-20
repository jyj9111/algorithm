package baekjoon.Simulation_0x0D;
/*
*  이번 문제는 문제 이해도가 낮아서 구현안이 안떠오름
*  이것 저것 해봐야 할듯.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj13335_v1 { // Boj13335: 트럭
    static int nNum, wNum, lNum;
    static List<Integer> trucks =  new ArrayList<>();
    static boolean[] isSameTime;

    public static void main(String[] args) throws IOException {
        receiveInput();

        int time = 0;

        for (int i = 0; i < nNum; i++) {
            int count = 0;
            int cars = countCrossCars(i);

            while(true) {

                if(count == wNum){
                    System.out.println(i);
                    time += (count + cars);
                    if(cars != 0)
                        i += (cars - 1);
                    if(isSameTime[i]) time--;
                    break;
                }

                count++;
            }
        }
        System.out.println(time);
    }

    private static int countCrossCars(int i) {
        int sum = trucks.get(i);
        int result = 0;

        for (int j = i + 1; j < trucks.size(); j++) {
            sum += trucks.get(j);

            if(sum > lNum) {
                result = j;
                break;
            }
        }

        if(result > wNum) result = wNum;
        if(result > 1) isSameTime[i + result - 1] = true;
        return result;
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        wNum = Integer.parseInt(input[1]);
        lNum = Integer.parseInt(input[2]);

        isSameTime = new boolean[nNum];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            trucks.add(Integer.parseInt(input2[i]));
        }
    }
}
