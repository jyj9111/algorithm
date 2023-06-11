package baekjoon.Simulation_0x0D;

import java.io.*;
import java.util.ArrayList;

public class Boj15686 { //Boj15686: 치킨 배달 (시뮬레이션)
    static int nNum;
    static int mNum;
    static boolean[] isUsed;    // 백트래킹을 위한
    static int[] choiceBHC;     // M만큼 뽑힌 치킨집 저장 배열
    static int min;             // 도시의 치킨거리 최소값

    static ArrayList<Pair> home = new ArrayList<>();    // 집 위치 리스트
    static ArrayList<Pair> bhc = new ArrayList<>();     // 치킨집 위치 리스트

    public static class Pair { // 위치 표시를 위한 클래스
        int x;
        int y;

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
        // 입력 --------------------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);

        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < nNum; j++) {
                if(input2[j].equals("1")) home.add(new Pair(i, j));
                else if(input2[j].equals("2")) bhc.add(new Pair(i, j));
            }
        }
        // --------------------------------------------------------------------------

        // 처리 ----------------------------
        isUsed = new boolean[bhc.size()];
        choiceBHC = new int[mNum];
        //min = 300;            // 수정 전 코드
        min =Integer.MAX_VALUE; // <-- 수정 (feat.정은님)
        solve(0, 0);
        // ---------------------------------

        // 출력 ----------------
        bw.append(min + "");
        bw.flush();
        br.close();
        bw.close();
        // --------------------
    }

    // 백트래킹으로 임의의 수(mNum) 치킨집 인덱스를 뽑아 도시의 치킨거리 최소값 산출
    private static void solve(int num, int st) {
        if(num == mNum) {
            calculateCDOC(choiceBHC);
            return;
        }

        for (int i = st; i < bhc.size(); i++) {
            if(!isUsed[i]) {
                choiceBHC[num] = i;
                isUsed[i] = true;
                //solve(num + 1, i);   // 수정 전 코드
                solve(num + 1, i + 1); // <-- 수정 (feat.정은님)
                isUsed[i] =  false;
            }
        }
    }

    // 도시의 치킨거리 최소값 계산 메소드
    private static void calculateCDOC(int[] stores) {
        // 배열 초기화
        int[] result = new int[home.size()];
        for (int i = 0; i < result.length; i++) {
            //result[i] = 200;             // 수정 전 코드
            result[i] = Integer.MAX_VALUE; // <-- 수정 (feat.정은님)
        }
        // 뽑힌 치킨집 수만큼 반복
        for (int i = 0; i < stores.length; i++) {
            int crr = stores[i];
            // 한 치킨집에 대한 치킨거리 계산 후 최소거리를 배열에 저장
            for (int j = 0; j < home.size(); j++) {
                int temp = calculateCD(crr, j);
                if(result[j] > temp) result[j] = temp;
            }
        }
        // result[]에 저장된 값으로 도시의 치킨거리 산출
        int cityRoad = 0;
        for (int i = 0; i < result.length; i++) {
            cityRoad += result[i];
        }
        // 도시의 치킨거리 최소값 산출
        if(min > cityRoad) min = cityRoad;
    }

    // 한 집과 한 치킨집 사이의 치킨거리 계산 메소드
    private static int calculateCD(int i, int j) {
        return Math.abs(bhc.get(i).getX() - home.get(j).getX())
                + Math.abs(bhc.get(i).getY() - home.get(j).getY());
    }
}