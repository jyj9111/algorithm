package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj14500 { // Boj14500: 테트로미노
    static int nNum, mNum;
    static int[][] map;

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
        process();
    }

    private static void process() {
        Pair[][] tetrominos = new Pair[][] {
                {new Pair(0, 1), new Pair(1, 0), new Pair(1, 1)},   // 네모

                {new Pair(0, 1), new Pair(0, 2), new Pair(0, 3)},   // 1자-가로
                {new Pair(1, 0), new Pair(2, 0), new Pair(3, 0)},   // 1자-세로

                {new Pair(1, 0), new Pair(1, 1), new Pair(2, 1)},   // Z - 1
                {new Pair(0, 1), new Pair(-1, 1), new Pair(-1, 2)},   // Z - 2
                {new Pair(1, 0), new Pair(1, -1), new Pair(2, -1)},   // Z - 3
                {new Pair(0, 1), new Pair(1, 1), new Pair(1, 2)},   // Z - 4

                {new Pair(1, 0), new Pair(2, 0), new Pair(2, 1)},   // L자- 1
                {new Pair(0, 1), new Pair(0, 2), new Pair(-1, 2)},   // L자- 2
                {new Pair(0, 1), new Pair(1, 1), new Pair(2, 1)},   // L자- 3
                {new Pair(0, 1), new Pair(0, 2), new Pair(1, 0)},   // L자- 4
                {new Pair(1, 0), new Pair(2, 0), new Pair(2, -1)},   // L자- 5
                {new Pair(0, 1), new Pair(0, 2), new Pair(1, 2)},   // L자- 6
                {new Pair(0, 1), new Pair(1, 0), new Pair(2, 0)},   // L자- 7
                {new Pair(1, 0), new Pair(1, 1), new Pair(1, 2)},   // L자- 8

                {new Pair(0, 1), new Pair(1, 1), new Pair(0, 2)},   // ㅜ자- 1
                {new Pair(1, 0), new Pair(1, 1), new Pair(2, 0)},   // ㅜ자- 2
                {new Pair(0, 1), new Pair(-1, 1), new Pair(0, 2)},   // ㅜ자- 3
                {new Pair(1, 0), new Pair(1, -1), new Pair(2, 0)}   // ㅜ자- 4
        };

        int max = -1;

        for (Pair[] tetromino : tetrominos) {
            int[][] temp = makeArr(tetromino);
            int[] dx = temp[0];
            int[] dy = temp[1];

            for (int j = 0; j < nNum; j++) {
                for (int k = 0; k < mNum; k++) {
                    int result = solution(dx, dy, j, k);
                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(max);
    }

    private static int solution(int[] dx, int[] dy, int j, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(j, k));

        int sum = 0;
        boolean isBreak = false;

        while(!queue.isEmpty()) {
            Pair crr = queue.remove();
            sum += map[crr.getX()][crr.getY()];

            for (int dir = 0; dir < 3; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum) {
                    isBreak = true;
                    break;
                }
                sum += map[nx][ny];
            }
        }

        return isBreak ? 0 : sum;
    }

    private static int[][] makeArr(Pair[] in) {
        int[][] temp = new int[2][3];

        for (int i = 0; i < in.length; i++) {
            temp[0][i] = in[i].getX();
            temp[1][i] = in[i].getY();
        }

        return temp;
    }

    // 입력 메소드
    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        map = new int[nNum][mNum];
        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }
        br.close();
    }
}
