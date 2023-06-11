package baekjoon.Simulation_0x0D;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Boj14891_origin { // Boj14891: 톱니바퀴 (시뮬레이션)

    static Deque<Integer> t1 = new ArrayDeque<>();
    static Deque<Integer> t2 = new ArrayDeque<>();
    static Deque<Integer> t3 = new ArrayDeque<>();
    static Deque<Integer> t4 = new ArrayDeque<>();
    static int kNum;
    static int[][] data;
    static boolean[] rotateFlag;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        receiveInput();

        for (int i = 0; i < kNum; i++) {
            rotateFlag = new boolean[3];

            int gear = data[i][0];
            int dir = data[i][1];

            checkGearsPole();

            if(gear == 1) {
                rotateGear1(dir);
                if(!rotateFlag[0]) continue;
                rotateGear2(-dir);
                if(!rotateFlag[1]) continue;
                rotateGear3(dir);
                if(rotateFlag[2]) rotateGear4(-dir);
            } else if (gear == 2) {
                rotateGear2(dir);
                if(rotateFlag[0]) rotateGear1(-dir);
                if(!rotateFlag[1]) continue;
                rotateGear3(-dir);
                if(rotateFlag[2]) rotateGear4(dir);

            } else if (gear == 3) {
                rotateGear3(dir);
                if(rotateFlag[2]) rotateGear4(-dir);
                if(!rotateFlag[1]) continue;
                rotateGear2(-dir);
                if(rotateFlag[0]) rotateGear1(dir);
            } else {
                rotateGear4(dir);
                if(!rotateFlag[2]) continue;
                rotateGear3(-dir);
                if(!rotateFlag[1]) continue;
                rotateGear2(dir);
                if(rotateFlag[0]) rotateGear1(-dir);
            }
        }

        int sum = 0;
        if(t1.getFirst() == 1) sum += t1.getFirst();
        if(t2.getFirst() == 1) sum += t2.getFirst() * 2;
        if(t3.getFirst() == 1) sum += t3.getFirst() * 4;
        if(t4.getFirst() == 1) sum += t4.getFirst() * 8;

        bw.append(sum + "");
        bw.flush();
        bw.close();
    }

    private static void checkGearsPole() {
        int t1Tot2 = 0;
        int idx = 0;
        for(int temp : t1) {
            if(idx == 2) t1Tot2 = temp;
            idx++;
        }

        int t2Tot1 = 0;
        int t2Tot3 = 0;
        idx = 0;
        for(int temp : t2) {
            if(idx == 2) t2Tot3 = temp;
            if(idx == 6) t2Tot1 = temp;
            idx++;
        }

        int t3Tot2 = 0;
        int t3Tot4 = 0;
        idx = 0;
        for(int temp : t3) {
            if(idx == 2) t3Tot4 = temp;
            if(idx == 6) t3Tot2 = temp;
            idx++;
        }

        int t4Tot3 = 0;
        idx = 0;
        for(int temp : t4) {
            if(idx == 6) t4Tot3 = temp;
            idx++;
        }
        if(t1Tot2 != t2Tot1) {
            rotateFlag[0] = true;
        }
        if(t2Tot3 != t3Tot2) {
            rotateFlag[1] = true;
        }
        if(t3Tot4 != t4Tot3) {
            rotateFlag[2] = true;
        }
    }

    private static void rotateGear1(int dir) {
        if(dir == 1)
            t1.addFirst(t1.removeLast());
        else
            t1.addLast(t1.removeFirst());
    }

    private static void rotateGear2(int dir) {
        if(dir == 1)
            t2.addFirst(t2.removeLast());
        else
            t2.addLast(t2.removeFirst());
    }

    private static void rotateGear3(int dir) {
        if(dir == 1)
            t3.addFirst(t3.removeLast());
        else
            t3.addLast(t3.removeFirst());
    }

    private static void rotateGear4(int dir) {
        if(dir == 1)
            t4.addFirst(t4.removeLast());
        else
            t4.addLast(t4.removeFirst());
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            t1.add(Integer.parseInt(input[i]));
        }
        input = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            t2.add(Integer.parseInt(input[i]));
        }
        input = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            t3.add(Integer.parseInt(input[i]));
        }
        input = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            t4.add(Integer.parseInt(input[i]));
        }

        kNum = Integer.parseInt(br.readLine());
        data = new int[kNum][2];
        for (int i = 0; i < kNum; i++) {
            String[] input2 = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(input2[0]);
            data[i][1] = Integer.parseInt(input2[1]);
        }

        br.close();
    }

}
