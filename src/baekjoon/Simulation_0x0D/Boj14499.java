package baekjoon.Simulation_0x0D;

import java.io.*;

/*
*  초기 구상
*  1. 동, 서 방향으로 굴릴 땐 가로만 움직이고,
*     남, 북 방향으로 굴릴 땐 세로만 움직이기 때문에
*     두개의 덱(가로,세로)을 사용하면 좋겠다.
*  2. 주사위의 세로줄 맨밑이 바닥에 닿는면이다.
*            diceCol:
*               2
*  diceRow:  4 <1> 3 [6]
*               5
*              [6]
*
* */

public class Boj14499 { // Boj14499: 주사위 굴리기
    static int nNum, mNum, kNum, stX, stY;
    static int[][] map;                 // 지도
    static int[] command;               // 명령
    static int[] diceRow = new int[4];  // 주사위 전개도 가로줄
    static int[] diceCol = new int[4];  // 주사위 전개도 세로줄

    public static void main(String[] args) throws IOException {
        // 입력
        receiveInput();

        // 처리
        for (int i = 0; i < kNum; i++) {
            if(command[i] < 3)  // 동, 서
                rollingDice(diceRow, command[i]);
            else                // 북, 남
                rollingDice(diceCol, command[i]);
        }
    }

    private static void rollingDice(int[] dice, int cmd ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 0, -1, 1}; // 동,서,북,남 순서
        int[] dy = {1, -1, 0, 0};

        // 시작지점에서 명령대로 움직였을 때의 좌표
        int crrX = stX + dx[cmd - 1];
        int crrY = stY + dy[cmd - 1];

        // 범위 체크
        if(crrX < 0 || crrX >= nNum || crrY < 0 || crrY >= mNum) return;

        // 먼저 주사위를 입력받은 방향으로 굴린다.
        shiftDice(dice, cmd);

        // 굴린 주사위와 지도와의 상호작용 처리
        if(map[crrX][crrY] == 0)
            map[crrX][crrY] = dice[3];  // 지도의 값이 0일 때 주사위 바닥면 값을 넣어준다
        else {
            dice[3] = map[crrX][crrY];  // 0이 아닐때 지도의값을 주사위의 바닥면에 넣어준다.
            map[crrX][crrY] = 0;        // 주사위에 넣고 지도의 값은 0으로 변경
        }

        // 다음 작업을 위한 초기화
        stX = crrX;
        stY = crrY;
        // 한 명령 수행마다 윗면[1], 아랫면[3] 값을 공유해야한다.
        diceCol[1] = dice[1]; // 주사위 윗면, 가로와 세로가 겹치는 부분
        diceRow[1] = dice[1]; //

        diceCol[3] = dice[3]; // 주사위 아랫면, 가로와 세로가 겹치는 부분
        diceRow[3] = dice[3]; //

        // 출력
        bw.append(dice[1] + "\n"); // 윗면[1] 값 출력
        bw.flush();
    }

    private static void shiftDice(int[] arr, int cmd) {
        if(cmd % 3 == 1) { // cmd가 1,4(동,남)이면 오른쪽으로 쉬프트
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
        } else {            // cmd가 2,3(서,북)이면 왼쪽으로 쉬프트
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }
    }

    private static void receiveInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);
        stX = Integer.parseInt(input[2]);
        stY = Integer.parseInt(input[3]);
        kNum = Integer.parseInt(input[4]);
        map = new int[nNum][mNum];
        command = new int[kNum];

        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < mNum; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        String[] input3 = br.readLine().split(" ");
        for (int i = 0; i < kNum; i++) {
            command[i] = Integer.parseInt(input3[i]);
        }

        br.close();
    }
}
