package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7576 { //Boj7576: 토마토

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[0]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[1002][1002];
        int[][] distance = new int[1002][1002];

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(str[j]);
                if(board[i][j] == 1)
                    queue.add(new Pair(i, j));
                if(board[i][j] == 0)
                    distance[i][j] = -1;
            }
        }

        while (!queue.isEmpty()) {
            Pair crr = queue.remove();

            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (distance[nx][ny] >= 0) {
                    continue;
                }
                distance[nx][ny] = distance[crr.getX()][crr.getY()] + 1;
                queue.add(new Pair(nx, ny));
            }
        }
        int max = 0;
        boolean isNotAll = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(distance[i][j] == -1) isNotAll = true;
                if(distance[i][j] > max) max = distance[i][j];
            }
        }

        if(isNotAll) {
            bw.append(Integer.toString(-1));
        } else {
            bw.append(Integer.toString(max));
        }
        bw.flush();

        br.close();
        bw.close();
    }
}