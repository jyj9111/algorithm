package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;

public class Boj1012 {// Boj 1012: 유기농 배추
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int testCase = Integer.parseInt(br.readLine());
        int n, m, k = 0;

        while (testCase > 0) {
            int[][] board = new int[52][52];
            boolean[][] vis = new boolean[52][52];

            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]); // 가로
            n = Integer.parseInt(input[1]); // 세로
            k = Integer.parseInt(input[2]); // 심어져있는 배추 갯수

            for (int i = 0; i < k; i++) {
                String[] inputK = br.readLine().split(" ");
                int x = Integer.parseInt(inputK[1]);
                int y = Integer.parseInt(inputK[0]);

                board[x][y] = 1;
            }

            int num = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 0 || vis[i][j])
                        continue;
                    num++;
                    LinkedList<Pair> queue = new LinkedList<>();
                    vis[i][j] = true;
                    queue.add(new Pair(i,j));

                    while (!queue.isEmpty()) {
                        Pair crr = queue.peekFirst();
                        queue.pop();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = crr.getX() + dx[dir];
                            int ny = crr.getY() + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;
                            if (vis[nx][ny] || board[nx][ny] != 1)
                                continue;
                            vis[nx][ny] = true;
                            queue.push(new Pair(nx, ny));
                        }
                    }
                }
            }
            bw.append(Integer.toString(num));
            bw.newLine();

            testCase--;
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
