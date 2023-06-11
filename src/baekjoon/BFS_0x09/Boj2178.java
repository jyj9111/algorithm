package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;

public class Boj2178 { //Boj 2178: 미로 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[102][102];
        int[][] distance = new int[102][102];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }

        LinkedList<Pair> queue = new LinkedList<>();
        distance[0][0] = 0;
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair crr = queue.peekFirst();
            queue.pop();
            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (distance[nx][ny] >= 0 || board[nx][ny] != 1)
                    continue;
                distance[nx][ny] = distance[crr.getX()][crr.getY()] + 1;
                queue.push(new Pair(nx, ny));
            }
        }

        bw.append(Integer.toString(distance[n - 1][m - 1] + 1));
        bw.flush();

        br.close();
        bw.close();
    }
}