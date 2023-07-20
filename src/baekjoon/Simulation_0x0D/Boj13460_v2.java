package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static Programmers.MakeArray2.solution;

// 전체맵 버전
public class Boj13460_v2 { // Boj13460: 구슬 탈출 2
    static int nNum, mNum;
    static int[][] map;
    static int[][] copyMap;
    static Pair[] stPos = new Pair[3];
    static Pair[] copyPos;
    static int count = 0;
    static int min = Integer.MAX_VALUE;

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
        copyMap = deepCopyArr(map);
        copyPos = deepCopyArr(stPos);
        playGame(0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void playGame(int num) {
        if(num == 10) {
            copyMap = deepCopyArr(map);
            copyPos = deepCopyArr(stPos);
            count = 0;
            return;
        }

        int result;
        for (int i = 0; i < 4; i++) {
            result = solution(i);
            if(result == -2) return;
            if(result > 0)
                min = Math.min(min, result);
            playGame(num + 1);
        }

    }

    private static int solution(int dir) {
        Pair rPos = copyPos[0];
        Pair bPos = copyPos[1];

        count++;

        boolean[] result = new boolean[2];

        if((dir == 0 && rPos.getY() < bPos.getY())
                || (dir == 1 && rPos.getX() < bPos.getX())
                || (dir == 2 && rPos.getY() > bPos.getY())
                || (dir == 3 && rPos.getX() > bPos.getX())
        ) {
            result[1] = blueBFS(dir, true);
            result[0] = redBFS(dir, false);
        } else {
            result[0] = redBFS(dir, true);
            result[1] = blueBFS(dir, false);
        }

        if(result[1])
            return -2;
        else if(!result[0])
            return -1;
        return count;
    }

    private static boolean redBFS(int dir, boolean isFirst) {
        int[] dx = {0, 1, 0, -1};   // 0: 오른쪽 1: 아래쪽
        int[] dy = {1, 0, -1, 0};   // 2: 왼쪽   3: 위쪽

        Pair blue = copyPos[1];
        Pair goal = copyPos[2];

        // 빨간 구슬
        boolean[][] visited = new boolean[nNum][mNum];
        Queue<Pair> redQue = new LinkedList<>();

        Pair crrRed = copyPos[0];
        redQue.add(crrRed);
        visited[crrRed.getX()][crrRed.getY()] = true;

        while (true) {
            Pair crr = redQue.poll();
            int nx = crr.getX() + dx[dir];
            int ny = crr.getY() + dy[dir];

            if(nx == goal.getX() && ny == goal.getY()) {
                return true;
            }

            if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum
                    || visited[nx][ny] || copyMap[nx][ny] == 1) {
                copyPos[0] = crr;
                return false;
            }

            if(!isFirst && (nx == blue.getX() && ny == blue.getY())) {
                copyPos[0] = crr;
                return false;
            }

            redQue.add(new Pair(nx, ny));
            visited[nx][ny] = true;
        }
//        return false;
    }

    private static boolean blueBFS(int dir, boolean isFirst) {
        int[] dx = {0, 1, 0, -1};   // 0: 오른쪽 1: 아래쪽
        int[] dy = {1, 0, -1, 0};   // 2: 왼쪽   3: 위쪽

        Pair red = copyPos[0];
        Pair goal = copyPos[2];

        // 파란 구슬
        boolean[][] visited = new boolean[nNum][mNum];
        Queue<Pair> blueQue = new LinkedList<>();

        Pair crrBlue = copyPos[1];
        blueQue.add(crrBlue);
        visited[crrBlue.getX()][crrBlue.getY()] = true;

        while (true) {
            Pair crr = blueQue.poll();
            int nx = crr.getX() + dx[dir];
            int ny = crr.getY() + dy[dir];

            if(nx == goal.getX() && ny == goal.getY()) {
                return true;
            }

            if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum
                    || visited[nx][ny] || copyMap[nx][ny] == 1) {
                copyPos[1] = crr;
                return false;
            }

            if(!isFirst && (nx == red.getX() && ny == red.getY())) {
                copyPos[1] = crr;
                return false;
            }

            blueQue.add(new Pair(nx, ny));
            visited[nx][ny] = true;
        }
//        return false;
    }

    private static void print(int[][] arr) {
        for(int[] temp : arr) {
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
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

