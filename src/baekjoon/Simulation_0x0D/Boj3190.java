package baekjoon.Simulation_0x0D;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Boj3190 { // Boj3190: 뱀
    static int nNum, kNum, lNum;
    static int[][] map;
    static DirInfo[] directions;
    static Deque<Pair> snake = new LinkedList<>();

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
    private static class DirInfo {
        private int sec;
        private String dir;

        public DirInfo(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }

        public int getSec() {
            return sec;
        }

        public String getDir() {
            return dir;
        }
    }

    public static void main(String[] args) throws IOException {
        receiveInput();
        playGame();
    }

    private static void playGame() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        snake.add(new Pair(0, 0));

        int time = 0;   // 게임 시간 체크 변수
        int dir = 0;    // 0:동, 1:남, 2:서, 3:북
                        // 현재 방향 나타내는 변수
        while (!queue.isEmpty()) {
            time++;
            Pair crr = queue.remove(); // 현재 위치 획득

            // 진행 방향 앞칸의 좌표 획득
            int nx = crr.getX() + dx[dir];
            int ny = crr.getY() + dy[dir];
            Pair next = new Pair(nx, ny);

            // 범위 체크
            // 벽에 부딪히면 Game Over
            if(nx < 0 || nx >= nNum || ny < 0 || ny >= nNum) break;
            // 뱀의 몸에 부딪히면 Game Over
            if(isClashed(next)) break;

            // 2(사과)를 만나면 0으로 바꿔주고
            if(map[nx][ny] == 2)
                map[nx][ny] = 0;
            // 아니면 꼬리를 줄인다.(총길이는 동일)
            else
                snake.removeLast();
            // 사과를 만나든 안만나든 공통 작업
            queue.add(next);
            snake.addFirst(next);
            dir = checkDirection(time ,dir);
        }

        bw.append(time + "");
        bw.flush();
        bw.close();
    }

    // 뱀과 충돌했는지 확인하는 메소드
    private static boolean isClashed(Pair pos) {
        for(Pair temp : snake) {
            if(temp.getX() == pos.getX() && temp.getY() == pos.getY())
                return true;
        }
        return false;
    }

    // 방향 확인해서 변경해주는 메소드
    private static int checkDirection(int time, int dir) {
        for(DirInfo temp : directions) {
            if(temp.getSec() == time) {
                if(temp.getDir().equals("L"))
                    dir = (dir + 3) % 4;
                else
                    dir = (dir + 1) % 4;
            }
        }
        return dir;
    }

    // 입력값 받는 메소드
    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nNum = Integer.parseInt(br.readLine());
        map = new int[nNum][nNum];

        kNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < kNum; i++) {
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 2;
        }

        lNum = Integer.parseInt(br.readLine());
        directions = new DirInfo[lNum];
        for (int i = 0; i < lNum; i++) {
            String[] input = br.readLine().split(" ");
            directions[i] = new DirInfo(Integer.parseInt(input[0]), input[1]);
        }

        br.close();
    }
}
