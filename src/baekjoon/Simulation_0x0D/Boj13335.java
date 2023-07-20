package baekjoon.Simulation_0x0D;
/*
*  이번 문제는 문제 이해도가 낮아서 구현안이 안떠오름
*  이것 저것 해봐야 할듯.
* */
import java.io.*;
import java.util.*;

public class Boj13335 { // Boj13335: 트럭
    static int nNum, wNum, lNum;
    static Queue<Integer> trucks = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        wNum = Integer.parseInt(input[1]);
        lNum = Integer.parseInt(input[2]);

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < nNum; i++) {
            trucks.add(Integer.parseInt(input2[i]));
        }
        int minTime = 0;

        while(true) {
            if(trucks.isEmpty()) {
                minTime++;
                break;
            }
            int cars = crossCars();

            if(cars == 1) {
                trucks.remove();
                minTime += wNum;
            } else {
                int preWeight = 0;
                for (int i = 0; i < cars; i++) {
                    preWeight = trucks.remove();
                }
                minTime += wNum + cars - 1;
                if(!trucks.isEmpty() && preWeight + trucks.peek() <= lNum) minTime--;
            }
        }

        System.out.println(minTime);
    }

    private static int crossCars() {
        int idx = 0;
        int sum = 0;

        if(nNum < wNum) {
            for(int tmp : trucks) {
                sum += tmp;
                idx++;
                if(sum > lNum) {
                    idx--;
                    break;
                }
            }
        } else {
            for(int tmp : trucks) {
                if(idx == wNum) {
                    if(sum > lNum) idx--;
                    break;
                }
                sum += tmp;
                idx++;
            }
        }
        return idx;
    }
}
