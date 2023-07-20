package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15684 { // Boj15684: 사다리 조작
    private int nNum, mNum, hNum;
    private int[][] ladders;
    private int count = 0;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        nNum = Integer.parseInt(info.nextToken());
        mNum = Integer.parseInt(info.nextToken());
        hNum = Integer.parseInt(info.nextToken());

        ladders = new int[mNum][nNum];

        for (int i = 0; i < mNum; i++) {
            StringTokenizer rowInfo = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(rowInfo.nextToken());
            int col = Integer.parseInt(rowInfo.nextToken());
            ladders[row - 1][col - 1] = i + 1;
            ladders[row - 1][col] = i + 1;
        }
        System.out.println("--ladders--");
        print(ladders);
        System.out.println("--result--");
        for (int i = 0; i < nNum; i++) {
            descendLadder(0, i);
        }

        return 0;
    }

    private void descendLadder(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        count++;

        while(!queue.isEmpty()) {
            int[] crr = queue.peek();
            int crrX = crr[0];
            int crrY = crr[1];
            if (crrX >= mNum || crrY >= nNum) break;

            queue.poll();
            int data = ladders[crrX][crrY];

            if(data == 0) {
                queue.add(new int[]{crrX + 1, crrY});
                continue;
            }

            if(crrY - 1 < 0 && ladders[crrX][crrY + 1] == data) {
                queue.add(new int[]{crrX + 1, crrY + 1});
                continue;
            }
            if(crrY + 1 >= nNum && ladders[crrX][crrY - 1] == data) {
                queue.add(new int[]{crrX + 1, crrY - 1});
                continue;
            }

            if(ladders[crrX][crrY + 1] == data) {
                queue.add(new int[]{crrX + 1, crrY + 1});
                continue;
            }
            if(ladders[crrX][crrY - 1] == data) {
                queue.add(new int[]{crrX + 1, crrY - 1});
            }
        }
        int[] result = queue.poll();
        System.out.println(count + " => " + (result[1] + 1));
    }


    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        new Boj15684().solution();

    }
}
