package baekjoon.Simulation_0x0D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj14889 { // Boj14889: 스타트와 링크
    static int nNum, sum;
    static int min = Integer.MAX_VALUE;
    static int[][] scoreCard;
    static boolean[] isUsed;
    static List<int[]> teamList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nNum = Integer.parseInt(br.readLine());
        scoreCard = new int[nNum][nNum];
        for (int i = 0; i < nNum; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < nNum; j++) {
                scoreCard[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        Boj14889 center = new Boj14889();

        isUsed = new boolean[nNum];
        int[] select = new int[nNum / 2];
        center.backTracking(0, 0, select);

//        // backTracking() 디버깅용
//        for (int[] temp : teamList) {
//            System.out.println(Arrays.toString(temp));
//        }

        isUsed = new boolean[nNum / 2];
        center.divideTeam(teamList);
    }

    private void divideTeam(List<int[]> teamList) {
        int size = teamList.size();
        int[] start, link;
        int dif = 0;

        for (int i = 0; i < size / 2; i++) {
            //System.out.println("calculate " + i); // calculate() 디버깅용
            sum = 0;
            start = teamList.get(i);
            //System.out.print("start => "); //calculate() 디버깅용
            calculate(0, 0, start, new int[2]);
            dif = sum;


            sum = 0;
            link = teamList.get(size - i - 1);
            //System.out.print("link  => "); // calculate() 디버깅용
            calculate(0, 0, link, new int[2]);
            dif -= sum;
            min = Math.min(min, Math.abs(dif));
            //System.out.println(); //calculate() 디버깅용
            /*
            // divideTeam() 디버깅용
            System.out.print(i + ": ");
            System.out.print("start = " + Arrays.toString(start) + " ");
            System.out.println("link = " + Arrays.toString(link));
             */
        }

        System.out.println(min);
    }

    private void calculate(int num, int st, int[] arr, int[] answer) {
        if(num == answer.length) {
            int x = answer[0];
            int y = answer[1];
            /* calculate() 디버깅용
            System.out.printf("scoreCard[%d][%d]: %d, scoreCard[%d][%d]: %d, sum : %d\n",
                    x, y, scoreCard[x][y],
                    y, x, scoreCard[y][x],
                    scoreCard[x][y] + scoreCard[y][x]
            );
            */
            sum += (scoreCard[x][y] + scoreCard[y][x]);
            return;
        }

        for (int i = st; i < arr.length; i++) {
            if (!isUsed[i]) {
               answer[num] = arr[i];
               isUsed[i] = true;
               calculate(num + 1, i, arr, answer);
               isUsed[i] = false;
            }
        }
    }

    private void backTracking(int num, int st, int[] select) {
        if(num == select.length) {
            int[] temp = deepCopyArray(select);
            teamList.add(temp);
            return;
        }

        for (int i = st; i < isUsed.length; i++) {
            if(!isUsed[i]) {
                select[num] = i;
                isUsed[i] = true;
                backTracking(num + 1, i, select);
                isUsed[i] = false;
            }
        }
    }

    private static int[] deepCopyArray(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        return tmp;
    }
}
