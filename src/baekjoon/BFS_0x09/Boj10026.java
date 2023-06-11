package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Boj10026 { // Boj10026: 적록색약
    public int calculateBFS(int[][] greed, int num) {

        boolean[][] vis = new boolean[102][102];

        int[] dx ={1, 0, -1, 0};
        int[] dy ={0, 1, 0, -1};

        int count = 0;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(greed[i][j] == 0 || vis[i][j])
                    continue;

                count++;
                Queue<Pair> queue = new LinkedList<>();
                vis[i][j] = true;
                queue.add(new Pair(i, j));
                while(!queue.isEmpty()) {
                    Pair crr = queue.remove();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = crr.getX() + dx[dir];
                        int ny = crr.getY() + dy[dir];

                        if (nx < 0 || nx >= num || ny < 0 || ny >= num)
                            continue;
                        if(vis[nx][ny] || greed[nx][ny] != 1)
                            continue;

                        vis[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력처리
        int[][] rGreed = new int[102][102]; // "R" -> 1로 교체
        int[][] gGreed = new int[102][102]; // "G" -> 1로 교체
        int[][] bGreed = new int[102][102]; // "B" -> 1로 교체
        int[][] rgGreed = new int[102][102]; // "R","G" -> 1로 교체

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < num; j++) {
                if(input[j].equals("R") || input[j].equals("G")) { // 적녹그리드
                    rgGreed[i][j] = 1;
                }
                if(input[j].equals("R")) {
                    rGreed[i][j] = 1;
                }
                if(input[j].equals("G")) {
                    gGreed[i][j] = 1;
                }
                if(input[j].equals("B")) {
                    bGreed[i][j] = 1;
                }
            }
        }

        //BFS
        Boj10026 rgb = new Boj10026();

        int red = 0, green = 0, blue = 0, redGreen = 0;

        red = rgb.calculateBFS(rGreed, num);
        green = rgb.calculateBFS(gGreed, num);
        blue = rgb.calculateBFS(bGreed, num);
        redGreen = rgb.calculateBFS(rgGreed, num);

        bw.append(Integer.toString(red + green + blue) + " ");
        bw.append(Integer.toString(redGreen + blue));
        bw.flush();

        br.close();
        bw.close();
    }
}