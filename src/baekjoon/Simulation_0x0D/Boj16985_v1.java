package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16985_v1 { // Boj16985: Maaaaaaaaze
    static List<int[][]> boardList = new ArrayList<>();
    static int[] boardNums = new int[5];
    static int[] rotateNums = new int[5];
    static boolean[] isUsed = new boolean[5];
    static int min = Integer.MAX_VALUE;

    private static class Coord{
        private int x, y, z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력
        receiveInput();
        // 처리
        pickBoardNums(0);
        // 출력
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(min);
    }
    /*  -- pickBoardNums() --
    *
    *   백트래킹으로 판의 순서 정보를(boardNums[]) 생성해서
    *   pickBoardNums() -> pickRotateNums() 로 정보를 넘긴다.
    *
    *   ex) boardNums[]
    *       0 1 2 3 4
    *       0 1 2 4 3
    *       0 1 3 2 4
    *       ...
    *       4 3 2 1 0
    * */
    private static void pickBoardNums(int num) {
        if(num == 5) {
            pickRotateNums(0, boardNums);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if(!isUsed[i]) {
                boardNums[num] = i;
                isUsed[i] = true;
                pickBoardNums(num + 1);
                isUsed[i] = false;
            }
        }
    }
    /*  -- pickRotateNums() --
    *
    *   백트래킹으로 각 판의 회전 정보(rotateNums[])를 생성해서
    *   pickRotateNums() -> makeMaze() 로
    *   넘겨받은 판의 순서정보(boardNums[])와 회전정보(rotateNums[])를 넘겨준다.
    *
    *   ex) rotateNums[]
    *       0 0 0 0 0
    *       0 0 0 0 1
    *       ...
    *       3 3 3 3 2
    *       3 3 3 3 3
    * */
    private static void pickRotateNums(int num, int[] pBoardNums) {
        if(num == 5) {
            makeMaze(pBoardNums, rotateNums);
            return;
        }
        for (int i = 0; i < 3; i++) {
            rotateNums[num] = i;
            pickRotateNums(num + 1, pBoardNums);
        }
    }
    /*  -- makeMaze() --
    *   넘겨받은 판의 순서정보(boardNums[])와 회전정보(rotateNums[])를 가지고
    *   [5][5][5] 큐브형태의 미로를 만든다.
    *   만들고 BFS 를 돌려서 최단거리를 찾는다.
    *
    *   ex) boardNums[]   rotateNums[]
    *       0 1 2 3 4  =>  0 0 0 0 0  => makeMaze();
    *                      0 0 0 0 1  => makeMaze();
    *                      ...           ...
    *                      3 3 3 3 3
    *       ...            ...
    *       ...            ...
    *       ...            ...
    *
    *       4 3 2 1 0  =>  0 0 0 0 0
    *                      0 0 0 0 1
    *                      ...
    *                      3 3 3 3 3
    * */

    private static void makeMaze(int[] pBoardNums, int[] pRotateNums) {

        List<int[][]> copyBoardList = new ArrayList<>();
        for(int[][] temp : boardList) {
            copyBoardList.add(deepCopyArr(temp));
        }

        int[][][] maze = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            maze[i] = rotateBoard(copyBoardList.get(pBoardNums[i]), pRotateNums[i]);
        }

        if(maze[0][0][0] == 0 || maze[4][4][4] == 0) return;

        bfs(maze);
    }

    private static void bfs(int[][][] arr) {

        int[] dx = {0, 1, 0, 0, -1, 0};
        int[] dy = {0, 0, 1, 0, 0, -1};
        int[] dz = {1, 0, 0, -1, 0, 0};

        int[][][] distance = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    distance[i][j][k] = -1;
                }
            }
        }

        Queue<Coord> queue = new LinkedList<>();

        distance[0][0][0] = 0;
        queue.add(new Coord(0, 0, 0));

        while(!queue.isEmpty()) {
            Coord crr = queue.remove();

            for (int dir = 0; dir < 6; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];
                int nz = crr.getZ() + dz[dir];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5)
                    continue;
                if(distance[nz][nx][ny] >= 0 || arr[nz][nx][ny] == 0)
                    continue;
                distance[nz][nx][ny] = distance[crr.getZ()][crr.getX()][crr.getY()] + 1;
                queue.add(new Coord(nx, ny, nz));
            }
        }

        if(distance[4][4][4] == -1) return;

        min = Math.min(min, distance[4][4][4]);
    }

    private static int[][] rotateBoard(int[][] board, int dir) {
        int row = board.length;
        int col = board[0].length;
        int[][] result =  new int[col][row];

        if(dir == 0) // dir: 0 -> 시계방향 0도 회전
            return board;

        else if(dir == 1) { // dir: 1 -> 시계방향 90도 회전
            for (int i = 0; i < row; i++) {
                int[] temp = board[row - i - 1];
                for (int j = 0; j < col; j++) {
                    result[j][i] = temp[j];
                }
            }
            return result;
        }

        else if(dir == 2) { // dir: 2 -> 시계방향 180도 회전
            return rotateBoard(rotateBoard(board, 1), 1);
        }

        else { // dir: 3 -> 시계방향 270도 회전
            return rotateBoard(rotateBoard(board,2), 1);
        }
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            int[][] arr = new int[5][5];

            for (int j = 0; j < 5; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < 5; k++) {
                    arr[j][k] = Integer.parseInt(input[k]);
                }
            }

            boardList.add(arr);
        }
    }

    private static int[][] deepCopyArr(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void print(int[][][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < board[i][j].length; k++) {
                    System.out.print(board[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}
