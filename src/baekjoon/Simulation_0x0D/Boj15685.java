package baekjoon.Simulation_0x0D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15685 { // Boj15685: 드래곤 커브 (최종제출)
    private final int[][] map = new int[101][101];

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < nNum; i++) {
            StringTokenizer infoToken = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(infoToken.nextToken());
            int y = Integer.parseInt(infoToken.nextToken());
            int dir = Integer.parseInt(infoToken.nextToken());
            int gen = Integer.parseInt(infoToken.nextToken());
            // 입력 정보를 가지고 드래곤 커브 생성 및 기록
            process(x, y, dir, gen);
        }

        return countSquare(map);
    }

    private void process(int x, int y, int dir, int gen) {
        List<Integer> originList = new ArrayList<>();
        List<Integer> copyList;
        originList.add(dir);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 세대(gen)에 맞는 방향들을 담은 리스트 생성
        for (int i = 0; i < gen; i++) {
            copyList = new ArrayList<>(originList);
            Collections.reverse(copyList);
            for (int temp : copyList) {
                originList.add((temp + 1) % 4);
            }
        }

        // 위에서 생성한 리스트를 토대로 map에 기록남기기
        map[y][x] = 1;
        for (int crrDir : originList) {
            x += dx[crrDir];
            y += dy[crrDir];

            if (x < 0 || x >= 101 || y < 0 || y >= 101) continue;
            map[y][x] = 1;
        }
    }

    private int countSquare(int[][] arr) {
        int[] dx = {1, 0, 1};
        int[] dy = {0, 1, 1};

        int row = arr.length;
        int col = arr[0].length;

        int count = 0;

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if(arr[i][j] != 1) continue;
                boolean isSquare = true;

                for (int dir = 0; dir < 3; dir++) {
                    int crrX = j + dx[dir];
                    int crrY = i + dy[dir];

                    if (arr[crrY][crrX] != 1) {
                        isSquare = false;
                        break;
                    }
                }
                if (isSquare) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Boj15685().solution());
    }
}
