package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 전체맵 버전
public class Boj13460 { // Boj13460: 구슬 탈출 2
    static int nNum, mNum;
    static int count;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static Pair[] stPos = new Pair[3];

    private static class Pair {
        private int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        receiveInput();
        solution();

//        if(min == Integer.MAX_VALUE) System.out.println(-1);
//        else System.out.println(min);

    }

    private static void solution() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] distance = new int[nNum][mNum];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = -1;
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(stPos[0]);
        distance[stPos[0].getX()][stPos[0].getY()] = 0;

        while(!queue.isEmpty()) {
            Pair crr = queue.remove();

            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum)
                    continue;
                if(distance[nx][ny] >= 0 || map[nx][ny] == 1)
                    continue;

                distance[nx][ny] = distance[crr.getX()][crr.getY()] + 1;
                queue.add(new Pair(nx, ny));
            }
        }
        print(distance);
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if(ints[j] == -1) System.out.print(ints[j] + " ");
                else if(ints[j] >= 10) System.out.print(ints[j] + " ");
                else System.out.print(" " + ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        map = new int[nNum][mNum];
        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < mNum; j++) {
                if(input2[j].equals(".")) map[i][j] = 0;
                else if(input2[j].equals("R")) {
                    map[i][j] = 2;
                    stPos[0] = new Pair(i, j);
                }
                else if(input2[j].equals("B")) {
                    map[i][j] = 3;
                    stPos[1] = new Pair(i, j);
                }
                else if(input2[j].equals("O")) {
                    map[i][j] = 4;
                    stPos[2] = new Pair(i, j);
                }
                else map[i][j] = 1;
            }
        }

    }
    private static int[][] deepCopyArr(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }
    private static Pair[] deepCopyArr(Pair[] arr) {
        Pair[] temp = new Pair[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
}

