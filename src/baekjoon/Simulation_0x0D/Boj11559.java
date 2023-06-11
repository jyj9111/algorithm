package baekjoon.Simulation_0x0D;

import java.io.*;
import java.util.*;
/*
    초기 구상
    1. bfs로 4개이상 뿌요들 터트리기
    2. 2048(EASY) 문제에서 사용했던 방법으로 남은 뿌요들 아래로 몰기
    3. 터질게 없을 때까지 반복
    4. 1번 수행완료시 count 증가
*/
public class Boj11559 { //Boj11559: Puyo Puyo (시뮬레이션)
    static String[][] board = new String[12][6]; // 입력받는 게임판
    static int count = 0;                        // 연쇄 카운트 변수

    // 좌표저장을 위한 클래스
    private static class Pair {
        int x, y;

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
        //-- 입 력 -----------------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 12; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                board[i][j] = input[j];
            }
        }

        //-- 처 리 ------------------------------------------------------------------
        while(true) {
            if(!checkPuyo()) { // BFS 로 터질수 있는지 탐색 후, 터졌으면 true 안 터졌으면 false 반환
                break;           // 안터졌으면 반복문 탈출, 바로 탈출 시 count = 0
            }
            count++;             // 터졌으면 count증가
            putDown();           // 잔여 뿌요들 아래로 정렬
        }

        //-- 출 력 ------------------------------------------------------------------
        bw.append(count + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean checkPuyo() {
        int resutl = 0;

        resutl += bfs("R");
        resutl += bfs("G");
        resutl += bfs("B");
        resutl += bfs("P");
        resutl += bfs("Y");

        return resutl == 0 ? false : true;
    }

    private static int bfs(String target) {
        boolean[][] vis = new boolean[12][6];
        boolean isPop = false;  // <- 기존 bfs에서 추가 된 코드

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(!board[i][j].equals(target) || vis[i][j])
                    continue;
                Queue<Pair> que = new LinkedList<>();       // 뿌요 탐색을 위한 큐
                ArrayList<Pair> arr = new ArrayList<>();    // 탐색한 뿌요 크기와 4이상일때 처리를 위한 리스트
                                                            // <- 기존 bfs에서 추가 된 코드
                vis[i][j] = true;
                que.add(new Pair(i, j));
                arr.add(new Pair(i, j));    // <- 기존 bfs에서 추가 된 코드

                while(!que.isEmpty()) {
                    Pair crr = que.remove();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = crr.getX() + dx[dir];
                        int ny = crr.getY() + dy[dir];
                        if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
                            continue;
                        if(vis[nx][ny] || !board[nx][ny].equals(target))
                            continue;
                        vis[nx][ny] = true;
                        que.add(new Pair(nx, ny));
                        arr.add(new Pair(nx, ny));  // <- 기존 bfs에서 추가 된 코드
                    }
                }
                // 뿌요가 4개이상이면 popBubble() 수행
                // 1번 이상의 터짐현상이 있었는지 판단 하기 위한 isPop = true로 변경
                if(arr.size() >= 4) {
                    popPuyo(arr);
                    isPop = true;
                }
            }
        }

        if(isPop) return 1; // 한번이라도 터졌으면 1 반환
        else return 0;      // 아니면 0 반환
    }

    private static void popPuyo(ArrayList<Pair> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i).getX();
            int y = arr.get(i).getY();
            board[x][y] = ".";
        }
    }

    private static void putDown() {
        // 왼쪽부터 한 열씩 처리진행
        for (int i = 0; i < 6; i++) {
            Queue<String> que = new LinkedList<>();
            // 맨 아래 요소부터 탐색, '.'이면 pass, 뿌요면 큐에 추가
            for (int j = 11; j >= 0 ; j--) {
                if(board[j][i].equals(".")) continue;
                que.add(board[j][i]);
                board[j][i] = "."; // 뿌요를 뽑아내고 '.'로 교체
            }
            // 뽑아낸 뿌요 갯수만큼 board에 맨아래부터 추가
            int size = que.size();
            int idx = 11;

            for (int j = 0; j < size; j++) {
                String temp = que.remove();
                if(board[idx][i].equals(".")) board[idx][i] = temp;
                else board[--idx][i] = temp;
            }
        }
    }
}
