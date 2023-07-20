package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    1. 벽을 3개 세운다.    -> 백트래킹 사용
    2. 바이러스를 퍼트린다. -> BFS 사용
    3. 안전구역을 카운트한다.
*/

public class Boj14502 { // Boj14502: 연구소
    static int nNum, mNum;
    static int[][] map;
    static int[] nums = new int[3];
    static boolean[] isUsed;
    static List<Pair> safeList = new ArrayList<>();
    static int maxArea = Integer.MIN_VALUE;

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

        buildWall(0, 0);

        System.out.println(maxArea);
    }

    // 백트래킹을 통해 nums[]에 벽을 세우기 위한 좌표를 뽑는다.
    private static void buildWall(int num, int st) {
        if(num == 3) {
            solution(nums);
            return;
        }

        for (int i = st; i < safeList.size(); i++) {
            if(!isUsed[i]) {
                nums[num] = i;
                isUsed[i] = true;
                buildWall(num + 1, i);
                isUsed[i] = false;
            }
        }
    }

    // 벽을 세우고, 바이러스를 퍼트리고, 안전구역을 카운트한다.
    private static void solution(int[] arr) {
        int[][] copyMap = deepCopyArr(map);

        // 뽑은 좌표를 가지고 벽 세우기
        for(int idx : arr) {
            Pair crr = safeList.get(idx);
            copyMap[crr.getX()][crr.getY()] = 1;
        }

        // 바이러스 퍼트리기
        spreadTheVirus(copyMap);

        // 안전구역 카운트 하기
        int safeArea = countSafeArea(copyMap);

        // 안전구역의 최대치는 list 의 사이즈 - 3(새로 세워진 벽의 개수)
        if(safeArea == safeList.size() - 3) {
            System.out.println(safeArea);
            System.exit(0);
        }

        // 최대치 비교
        maxArea = Math.max(maxArea, safeArea);
    }

    // 바이러스 퍼트리기 위한 BFS 메소드
    private static void spreadTheVirus(int[][] copyMap) {
        boolean[][] visited = new boolean[nNum][mNum];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < nNum; i++) {
            for (int j = 0; j < mNum; j++) {
                if(copyMap[i][j] == 0 || copyMap[i][j] == 1 || visited[i][j])
                    continue;

                Queue<Pair> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.add(new Pair(i, j));

                while(!queue.isEmpty()) {
                    Pair crr = queue.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = crr.getX() + dx[dir];
                        int ny = crr.getY() + dy[dir];

                        if(nx < 0 || nx >= nNum || ny < 0 || ny >= mNum)
                            continue;
                        if(copyMap[nx][ny] == 1 || visited[nx][ny])
                            continue;

                        copyMap[nx][ny] = 2;
                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    private static int countSafeArea(int[][] copyMap) {
        int count = 0 ;
        for (int[] ints : copyMap) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (ints[j] == 0) count++;
            }
        }
        return count;
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        map = new int[nNum][mNum];
        for (int i = 0; i < nNum; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(input[j].equals("0")) safeList.add(new Pair(i, j));
            }
        }
        isUsed = new boolean[safeList.size()];
    }

    private static int[][] deepCopyArr(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }
}
