package baekjoon.BFS_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Boj4179 { // Boj 4179 : 불!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queueJ = new LinkedList<>();
        Queue<Pair> queueF = new LinkedList<>();

        String[][] board = new String[1002][1002];
        int[][] disJ = new int[1002][1002];
        int[][] disF = new int[1002][1002];

        String[] inputInt = br.readLine().split(" ");
        int row = Integer.parseInt(inputInt[0]);
        int column = Integer.parseInt(inputInt[1]);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                disJ[i][j] = -1;
                disF[i][j] = -1;
            }
        }

        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < column; j++) {
                board[i][j] = input[j];
                if(board[i][j].equals("J")) {
                    disJ[i][j] = 0;
                    queueJ.add(new Pair(i, j));
                }
                if(board[i][j].equals("F")) {
                    disF[i][j] = 0;
                    queueF.add(new Pair(i, j));
                }
            }
        }
        //BFS

        int[] dx ={1, 0, -1, 0};
        int[] dy ={0, 1, 0, -1};
        boolean isEscape = false;

        // 불 BFS 먼저 실행
        while(!queueF.isEmpty()) {
            Pair crr = queueF.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column)
                    continue;
                if(disF[nx][ny] >= 0 || board[nx][ny].equals("#"))
                    continue;

                disF[nx][ny] = disF[crr.getX()][crr.getY()] + 1;
                queueF.add(new Pair(nx, ny));
            }
        }


        // 지훈이 BFS 실행
        while(!queueJ.isEmpty()) {
            Pair crr = queueJ.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = crr.getX() + dx[dir];
                int ny = crr.getY() + dy[dir];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
                    bw.append(Integer.toString(disJ[crr.getX()][crr.getY()] + 1));
                    isEscape = true;
                    break;
                }
                if(disJ[nx][ny] >= 0 || board[nx][ny].equals("#"))
                    continue;
                if(disF[nx][ny] != -1 && disF[nx][ny] <= disJ[crr.getX()][crr.getY()] + 1)
                    continue;

                disJ[nx][ny] = disJ[crr.getX()][crr.getY()] + 1;
                queueJ.add(new Pair(nx, ny));
            }
        }

        if(!isEscape) bw.append("IMPOSSIBLE");
        bw.flush();

        br.close();
        bw.close();
    }
}