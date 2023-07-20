package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 전체맵 버전
public class Boj13460_vBackTracking { // Boj13460: 구슬 탈출 2
    static int nNum, mNum;
    static int count;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int[] directions = new int[10];
    static Pair[] stPos = new Pair[3];
    static Pair[] copyPos;

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
        makeCommand(0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    private static void makeCommand(int num) {
        if(num == 10) {
            playGame(directions);
            return;
        }

        for (int i = 0; i < 4; i++) {
            directions[num] = i;
            makeCommand(num + 1);
        }
    }

    private static void playGame(int[] dir) {
        int[][] copyMap = deepCopyArr(map);
        copyPos = deepCopyArr(stPos);
        count = 0;

        for (int i = 0; i < dir.length; i++) {
            int temp = solution(copyMap, dir[i]);

            if(temp == -2) {
                return;
            }
            if(temp >= 0 && temp < min) min = temp;
        }

    }

    private static int solution(int[][] copyMap, int dir) {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] distance = new int[nNum][mNum];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = -1;
            }
        }

        count++;

        // 파랑구슬
        Queue<Pair> blueQue = new LinkedList<>();
        blueQue.add(copyPos[1]);
        distance[copyPos[1].getX()][copyPos[1].getY()] = 0;

        while(true) {
            Pair crr = blueQue.remove();
            distance[crr.getX()][crr.getY()] = count;
            int nx = crr.getX() + dx[dir];
            int ny = crr.getY() + dy[dir];

            if(nx == copyPos[2].getX() && ny == copyPos[2].getY()) {
                return -2;
            }

            if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum
                    || distance[nx][ny] >= 0 || copyMap[nx][ny] == 1 || (nx == copyPos[0].getX() && ny == copyPos[0].getY())) {
                blueQue.add(crr);
                copyPos[1] = crr;
                break;
            }
            blueQue.add(new Pair(nx, ny));
            distance[nx][ny] = distance[crr.getX()][crr.getY()];
        }

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = -1;
            }
        }

        // 빨강구슬
        Queue<Pair> redQue = new LinkedList<>();
        redQue.add(copyPos[0]);
        distance[copyPos[0].getX()][copyPos[0].getY()] = 0;

        while(true) {
            Pair crr = redQue.remove();
            distance[crr.getX()][crr.getY()] = count;
            int nx = crr.getX() + dx[dir];
            int ny = crr.getY() + dy[dir];

            if(nx == copyPos[2].getX() && ny == copyPos[2].getY()) {
                return count;
            }

            if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum
                    || distance[nx][ny] >= 0 || copyMap[nx][ny] == 1 || (nx == copyPos[1].getX() && ny == copyPos[1].getY())) {
                redQue.add(crr);
                copyPos[0] = crr;
                break;
            }
            redQue.add(new Pair(nx, ny));
            distance[nx][ny] = distance[crr.getX()][crr.getY()];
        }

        return Integer.MAX_VALUE;
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
}

