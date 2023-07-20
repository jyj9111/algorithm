package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14890 { // Boj14890: 경사로
    static int nNum, lNum;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());
        nNum = Integer.parseInt(info.nextToken());
        lNum = Integer.parseInt(info.nextToken());

        map = new int[nNum][nNum];

        for (int i = 0; i < nNum; i++) {
            info = new StringTokenizer(br.readLine());
            for (int j = 0; j < nNum; j++) {
                map[i][j] = Integer.parseInt(info.nextToken());
            }
        }

        searchRoad();

    }

    private static void searchRoad() {
        int[][] copyMap = deepCopyArray(map);
        int count = 0;

        for (int i = 0; i < nNum; i++) {
            for (int j = 0; j < nNum - 1; j++) {
                if(copyMap[i][j] == copyMap[i][j + 1]) {    // 차이가 = 0
                    count++;
                    continue;
                }
                if(copyMap[i][j] - copyMap[i][j + 1] > 1)   // 차이가 1 보다 클 때
                    break;
                if(count < lNum)    // 경사로를 세울 수 없으면 못가는 길
                    break;

            }
        }

    }

    private static int[][] deepCopyArray(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] temp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
