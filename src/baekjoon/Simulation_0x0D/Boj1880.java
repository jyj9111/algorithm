package baekjoon.Simulation_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1880 { // Boj18808: 스티커 붙이기 (시뮬레이션)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int nNum, mNum = 4, kNum = 4;
    static int stX, stY;
    static int[][] board;
    static int[] saveXY = new int[2];

    public static void main(String[] args) throws IOException {
        Boj1880 md = new Boj1880();

        String[] input1 = br.readLine().split(" ");
        nNum = Integer.parseInt(input1[0]);
        mNum = Integer.parseInt(input1[1]);
        kNum = Integer.parseInt(input1[2]);
        board = new int[nNum][mNum];

        for (int stk = 0; stk < kNum; stk++) {
            int[][] sticker = md.getSticker();
/* board
*  1 0 0 => 1 0   0 0
*  1 1 0    1 1   1 0
*  0 0 0
*           1 1   1 0
*           0 0   0 0
* */
            int num = 4;
            while(num > 0) {
                if(md.compare(sticker)) {
                    md.putSticker(sticker);
                    printArr(board);
                    System.out.println("----------------");
                    break;
                } else {
                    sticker = md.rotateSticker(sticker);
                }
                num--;
            }
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }
    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private int[][] rotateSticker(int[][] sticker) {
        int rows = sticker.length;
        int cols = sticker[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - i - 1] = sticker[i][j];
            }
        }
        return result;
    }

    private void putSticker(int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                board[i + saveXY[0]][j + saveXY[1]] = sticker[i][j];
            }
        }
    }

    private boolean isPossible(int[][] spBoard, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if(spBoard[i][j] + sticker[i][j] == 2) return false;
            }
        }
        return true;
    }

    private boolean compare(int[][] sticker) {
        int[][] spBoard;

        for (int i = 0; i < nNum - stX + 1; i++) {
            for (int j = 0; j < mNum - stY + 1; j++) {
                spBoard = splitBoard(i, j); //
                if(isPossible(spBoard, sticker)) {
                    saveXY[0] = i;
                    saveXY[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] splitBoard(int x, int y) {
        int[][] result = new int[stX][stY];
        for (int i = x; i < stX; i++) {
            for (int j = y; j < stY; j++) {
                result[i - x][j - y] = board[i][j];
            }
        }
        return result;
    }

    private int[][] getSticker() throws IOException {
        String[] input = br.readLine().split(" ");
        stX = Integer.parseInt(input[0]);
        stY = Integer.parseInt(input[1]);
        int[][] sticker = new int[stX][stY];

        for (int i = 0; i < stX; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < stY; j++) {
                sticker[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return sticker;
    }
}
