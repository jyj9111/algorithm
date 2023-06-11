package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj12100 { //Boj12100: 2048(EASY) (시뮬레이션)
    static int nNum;
    static int[][] board;       // 원본 보드
    static int[][] pBoard;      // 연산에 사용할 보드(원본 복사본)
    static boolean[][] isUsed;  // 한번의 방향처리에서 사용 될 합침 여부 확인용

    public static void main(String[] args) throws IOException {
        // --------- 입력 ---------------------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nNum = Integer.parseInt(br.readLine());
        board = new int[nNum][nNum];

        for (int i = 0; i < nNum; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < nNum; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        // ------------------------------------------------------------------------------------
        // ----- 처리 ---- 바킹독님 <감시> 코드 참고로 풀이 -----------------------------------------
        int max = 0;    // 최댓값 저장 변수
        for (int tmp = 0; tmp < (1 << 10); tmp++) { // (1 << 2 * 5) 5자리 경우의 수
            pBoard = makeDeepCopyArr(board);        // board 복사
            //isUsed = new boolean[nNum][nNum];     // 수정 전 위치
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                isUsed = new boolean[nNum][nNum];   // 수정 후 위치
                int dir = brute % 4;
                brute /= 4;

                if(dir == 0) {          // 위
                    solveUP();
                } else if(dir == 1) {   // 오른쪽
                    solveRight();
                } else if(dir == 2) {   // 아래
                    solveDown();
                } else {                // 왼쪽
                    solveLeft();
                }

            }
            // max값 확인 부분
            for (int i = 0; i < nNum; i++) {
                for (int j = 0; j < nNum; j++) {
                    if(pBoard[i][j] > max) max = pBoard[i][j];
                }
            }
        }
        // ---- 출력 --------------------------------------------------------------------------
        System.out.println(max);
        // ------------------------------------------------------------------------------------
    }
    /* ex) 위 + 오른쪽 처리방법
            Q: 2,8             Q: 4             Q: 8,4             Q: 8
    2 4 0    2 _ _    4 4 0    _ 4 _    4 8 0    0 0 0    0 4 8    _ _ _    0 4 8
    2 0 0 => 0 _ _ => 8 0 0 => _ 0 _ => 8 0 0 => _ _ _ => 8 0 0 => 0 0 0 => 0 0 8
    8 4 0    0 _ _    0 4 0    _ 0 _    0 0 0    _ _ _    0 0 0    _ _ _    0 0 0

    */

    private static void solveUP() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j < nNum; j++) {
                if(pBoard[j][i] == 0) continue;
                que.add(pBoard[j][i]);
                pBoard[j][i] = 0;
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                //if(pBoard[idx][i] == 0) pBoard[idx++][i] = temp;  // 변경 전
                if(pBoard[idx][i] == 0) pBoard[idx][i] = temp;      // 변경 후
                else if(!isUsed[idx][i] && pBoard[idx][i] == temp) {
                    pBoard[idx][i] += temp;
                    isUsed[idx][i] = true;
                }
                else pBoard[++idx][i] = temp;
            }
        }
    }

    private static void solveRight() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0; j--) {
                if(pBoard[i][j] == 0) continue;
                que.add(pBoard[i][j]);
                pBoard[i][j] = 0;
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[i][idx] == 0) pBoard[i][idx] = temp;
                else if(!isUsed[i][idx] && pBoard[i][idx] == temp) {
                    pBoard[i][idx] += temp;
                    isUsed[i][idx] = true;
                }
                else pBoard[i][--idx] = temp;
            }
        }
    }

    private static void solveDown() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = nNum - 2; j >= 0 ; j--) {
                if(pBoard[j][i] == 0) continue;
                que.add(pBoard[j][i]);
                pBoard[j][i] = 0;
            }
            int size = que.size();
            int idx = nNum - 1;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[idx][i] == 0) pBoard[idx][i] = temp;
                else if(!isUsed[idx][i] && pBoard[idx][i] == temp) {
                    pBoard[idx][i] += temp;
                    isUsed[idx][i] = true;
                }
                else pBoard[--idx][i] = temp;
            }
        }
    }

    private static void solveLeft() {
        for (int i = 0; i < nNum; i++) {
            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j < nNum ; j++) {
                if(pBoard[i][j] == 0) continue;
                que.add(pBoard[i][j]);
                pBoard[i][j] = 0;
            }
            int size = que.size();
            int idx = 0;
            for (int j = 0; j < size; j++) {
                int temp = que.remove();
                if(pBoard[i][idx] == 0) pBoard[i][idx] = temp;
                else if(!isUsed[i][idx] && pBoard[i][idx] == temp) {
                    pBoard[i][idx] += temp;
                    isUsed[i][idx] = true;
                }
                else pBoard[i][++idx] = temp;
            }
        }
    }

    static private int[][] makeDeepCopyArr(int[][] arr) {
        int[][] result =  new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}