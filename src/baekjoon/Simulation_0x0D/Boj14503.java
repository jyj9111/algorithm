package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj14503 { // Boj14503: 로봇 청소기
    private static class Pair {
        private int x, y, dir;

        public Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public int getDir() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static int nNum, mNum;
    static Pair start;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        receiveInput();
        clean();
    }

    private static void clean() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            Pair crr = queue.remove();

            // 지금 위치가 청소가 가능하면 표시남겨주고 count++
            if(map[crr.getX()][crr.getY()] == 0) {
                map[crr.getX()][crr.getY()] = -1;
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int dir = (crr.dir + 3 * (i + 1)) % 4; // 반시계 방향 90도이므로 +3씩 해줘야 한다.
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                // 범위 체크
                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum) continue;
                if(map[nx][ny] != 0) continue;

                queue.add(new Pair(nx, ny, dir));
                break; // <- 이놈 때문에 시간 오래걸림..
            }

            // 위쪽에서 4방향 모두 이동 불가 지역이면 queue 가 비어있는 상태이기 때문에
            // 여기서 처리해준다.
            // 방향은 그대로 , 뒤로 한칸이동
            if(queue.isEmpty()) {
                int dir = crr.getDir();
                int nx = crr.getX() + dx[(dir + 2) % 4];
                int ny = crr.getY() + dy[(dir + 2) % 4];

                if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum) break;
                if(map[nx][ny] == 1) break;

                queue.add(new Pair(nx, ny, dir));
            }
        }
        System.out.println(count);
    }


    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        start = new Pair(
                Integer.parseInt(input2[0]),
                Integer.parseInt(input2[1]),
                Integer.parseInt(input2[2])
        );

        map = new int[nNum][mNum];
        for (int i = 0; i < nNum; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}
