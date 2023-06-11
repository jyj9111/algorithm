package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;

public class Boj1926 { //Boj 1926: 그림

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] dx = {1, 0, -1, 0};                           // 방문좌표에서 4방향 좌표 확인을 위한 x의 변화량 배열
        int[] dy = {0, 1, 0, -1};                           // 방문좌표에서 4방향 좌표 확인을 위한 y의 변화량 배열

        int[][] board = new int[102][102];                  // 범위가 2<= n,m <=100 이기 때문에
        boolean[][] vis = new boolean[102][102];            // 여유롭게 +2해서 배열 할당

        for (int i = 0; i < n; i++) {                       // 미로 => board에 입력
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        int maxArea = 0;                                    // 최대 면적 저장 변수
        int num = 0;                                        // 그림의 개수 저장 변수

        for (int i = 0; i < n; i++) {                       // n x m의 board를 돌면서 그림의 시작지점을 찾고
            for (int j = 0; j < m; j++) {                   // 시작지점으로부터 그림의 면적을 파악
                if(board[i][j] == 0 || vis[i][j])           // 그림이 아닌 곳 or 이미 방문한 곳 이면 다음 반복! -> j++
                    continue;
                // 그림이면서 처음 방문한 곳.
                num++;                                      // 일단 그림의 개수 +1
                LinkedList<Pair> queue = new LinkedList<>();// 큐를 생성.
                vis[i][j] = true;                           // 우선 방문표시.
                queue.add(new Pair(i,j));                   // 큐에 방문 좌표 삽입.
                int area = 0;                               // 현재 좌표에서 이어진 그림의 면적을 카운트 하기위한 변수;

                // 아래 반복문을 통해 현재 좌표에서 이어진 그림을 확인
                while (!queue.isEmpty()) {                  // 큐가 빌때까지 반복.
                    area++;                                 // 그림면적 카운트 +1
                    Pair crr = queue.peekFirst();           // 큐에 들어있는 시작 좌표를 crr 변수에 저장 후
                    queue.pop();                            // 큐에서 삭제!
                    for (int dir = 0; dir < 4; dir++) {     // 방문지점에서 상,하,좌,우 방향 확인하기 위한 for문
                        int nx = crr.getX() + dx[dir];      // 시작좌표 (x,y)에 순서대로 (x+1, y) -> (x, y+1) ->
                        int ny = crr.getY() + dy[dir];      // (x-1, y) -> (x,y-1) 좌표를 확인
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                            continue;                       // 인덱스범위를 넘어가지 않는지 체크.
                        if (vis[nx][ny] || board[nx][ny] != 1)
                            continue;                       // 4방향 중 방문한 곳 이거나 그림이 아니라면 Pass!
                        vis[nx][ny] = true;                 // 그렇지 않다면 방문표시 남기고
                        queue.push(new Pair(nx, ny));       // 큐에 담아준다.
                    }
                }
                maxArea = Math.max(maxArea, area);          // 1개의 그림을 찾을 때 마다 최대 넓이 값을 변경.
            }
        }
        bw.append(Integer.toString(num) + "\n");
        bw.append(Integer.toString(maxArea));
        bw.flush();

        br.close();
        bw.close();
    }
}