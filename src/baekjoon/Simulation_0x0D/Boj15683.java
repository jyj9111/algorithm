package baekjoon.Simulation_0x0D;


import java.io.*;
import java.util.ArrayList;


public class Boj15683 { // Boj15683 : 그림 (시뮬레이션)
    static int nNum;
    static int mNum;
    static boolean minFlag;
    static String[][] room;
    static boolean[][] totalRoom;
    //static Queue<Info> que = new LinkedList<>();
    static ArrayList<Info> que = new ArrayList<>();   // cctv 정보
    static ArrayList<Info> list = new ArrayList<>();  // 벽 정보

    // CCTV 타입과 위치저장용 클래스
    public static class Info {
        int type;
        int x;
        int y;

        public Info(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getType() {
            return type;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boj15683 bj = new Boj15683();
        // N, M 입력 받기
        String[] input = br.readLine().split(" ");
        nNum = Integer.parseInt(input[0]);
        mNum = Integer.parseInt(input[1]);
        // room 크기 정의
        room = new String[nNum][mNum];
        totalRoom = new boolean[nNum][mNum];

        // room 정보 입력 받기
        for (int i = 0; i < nNum; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < input2.length; j++) {
                room[i][j] = input2[j];
                totalRoom[i][j] = true;
                bj.setting(input2[j], i, j);
            }
        }

        bj.processCCTV();
        br.close();
    }

    // [메인] 모든 처리과정이 진행되는 메소드
    public void processCCTV() throws IOException {
        Info info;
        String[][] arr1, arr2, arr3, arr4, arr5;

        for (int i = 0; i < que.size(); i++) {
            info = que.get(i);

            if (info.type == 1) {
                arr1 = cctv1(info);
                makeTotalRoom(arr1);
            }
            if (info.type == 2) {
                arr2 = cctv2(info);
                makeTotalRoom(arr2);
            }
            if (info.type == 3) {
                arr3 = cctv3(info);
                makeTotalRoom(arr3);
            }
            if (info.type == 4) {
                arr4 = cctv4(info);
                makeTotalRoom(arr4);
            }
            if (info.type == 5) {
                arr5 = cctv5(info);
                makeTotalRoom(arr5);
            }
        }
        printResult();
    }

    // [처리] 각 cctv 타입 별로 사각지대 탐지가 정의 된 메소드
    private String[][] cctv1(Info info) {
        int min = 64;
        String[][] result = deepCopyArr(room);

        for (int k = 0; k < 4; k++) {
            String[][] temp = deepCopyArr(room);

            switch (k) {
                case 0: // 위
                    for (int i = info.getX() - 1; i >= 0; i--) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    break;
                case 1: // 아래
                    for (int i = info.getX() + 1; i < nNum; i++) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    break;
                case 2: // 왼쪽
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
                case 3: // 오른쪽
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
            }

            min = findMinBlindSpot(temp, min);

            if (minFlag) {
                result = deepCopyArr(temp);
                minFlag = false;
            }
        }
        return result;
    } // 1번 cctv
    private String[][] cctv2(Info info) {
        int min = 64;
        String[][] result = deepCopyArr(room);

        for (int k = 0; k < 2; k++) {
            String[][] temp = deepCopyArr(room);

            switch (k) {
                case 0: // 위, 아래
                    for (int i = info.getX() - 1; i >= 0; i--) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getX() + 1; i < nNum; i++) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    break;
                case 1: // 왼쪽, 오른쪽
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
            }
            min = findMinBlindSpot(temp, min);
            if (minFlag) {
                result = deepCopyArr(temp);
                minFlag = false;
            }
        }
        return result;
    } // 2번 cctv
    private String[][] cctv3(Info info) {
        int min = 64;
        String[][] result = deepCopyArr(room);

        for (int k = 0; k < 4; k++) {
            String[][] temp = deepCopyArr(room);

            switch (k) {
                case 0: // 위, 왼쪽
                    for (int i = info.getX() - 1; i >= 0; i--) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
                case 1: // 위, 오른쪽
                    for (int i = info.getX() - 1; i >= 0; i--) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
                case 2: // 아래, 왼쪽
                    for (int i = info.getX() + 1; i < nNum; i++) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
                case 3: // 아래, 오른쪽
                    for (int i = info.getX() + 1; i < nNum; i++) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
            }
            min = findMinBlindSpot(temp, min);

            if (minFlag) {
                result = deepCopyArr(temp);
                minFlag = false;
            }
        }
        return result;
    } // 3번 cctv
    private String[][] cctv4(Info info) {
        int min = 64;
        String[][] result = deepCopyArr(room);

        for (int k = 0; k < 2; k++) {
            String[][] temp = deepCopyArr(room);

            switch (k) {
                case 0: // 위 , 왼쪽, 오른쪽
                    for (int i = info.getX() - 1; i >= 0; i--) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
                case 1: // 아래, 왼쪽, 오른쪽
                    for (int i = info.getX() + 1; i < nNum; i++) {
                        if (!isWall(i, info.getY()))
                            temp[i][info.getY()] = "#";
                        else break;
                    }
                    for (int i = info.getY() - 1; i >= 0; i--) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    for (int i = info.getY() + 1; i < mNum; i++) {
                        if (!isWall(info.getX(), i))
                            temp[info.getX()][i] = "#";
                        else break;
                    }
                    break;
            }
            min = findMinBlindSpot(temp, min);

            if (minFlag) {
                result = deepCopyArr(temp);
                minFlag = false;
            }
        }
        return result;
    } // 4번 cctv
    private String[][] cctv5(Info info) {
        String[][] result = deepCopyArr(room);

        // 위
        for (int i = info.getX() - 1; i >= 0; i--) {
            if (!isWall(i, info.getY()))
                result[i][info.getY()] = "#";
            else break;
        } // 아래
        for (int i = info.getX() + 1; i < nNum; i++) {
            if (!isWall(i, info.getY()))
                result[i][info.getY()] = "#";
            else break;
        } // 왼쪽
        for (int i = info.getY() - 1; i >= 0; i--) {
            if (!isWall(info.getX(), i))
                result[info.getX()][i] = "#";
            else break;
        } // 오른쪽
        for (int i = info.getY() + 1; i < mNum; i++) {
            if (!isWall(info.getX(), i))
                result[info.getX()][i] = "#";
            else break;
        }

        return result;
    } // 5번 cctv

    // [입력] 받은 cctv위치 및 벽의 위치 ArraysList 추가 하기 위한 메소드
    private void setting(String str, int i, int j) {
        if (str.equals("1")) que.add(new Info(1, i, j));
        if (str.equals("2")) que.add(new Info(2, i, j));
        if (str.equals("3")) que.add(new Info(3, i, j));
        if (str.equals("4")) que.add(new Info(4, i, j));
        if (str.equals("5")) que.add(new Info(5, i, j));
        if (str.equals("6")) list.add(new Info(i, j));
    }
    // [처리] 벽에 막혔는지 확인을 위한 메소드
    private boolean isWall(int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Info info = list.get(i);
            if (x == info.getX() && y == info.getY())
                return true;
        }
        return false;
    }
    // [처리] 배열 딥카피를 위한 메소드
    private String[][] deepCopyArr(String[][] arr) {
        String[][] temp = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i].clone();
        }
        return temp;
    }

    // [진행중] 반례 해결을 위해 진행중...
    private boolean[] isPossibleDir(Info info, int type, int num) {
        boolean[] result = new boolean[4]; // 0: 위, 1: 아래, 2: 왼, 3: 오
        for (int i = 0; i < que.size(); i++) {

        }

        return result;
    }

    // [처리] 사각지대("0")의 최소값을 찾아 반환하는 메소드
    private int findMinBlindSpot(String[][] arr, int pre) {
        int crr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("0")) crr++;
            }
        }
        if (pre > crr) {
            minFlag = true;
            return crr;
        } else if (pre == crr) {
            return pre;
        } else
            return pre;
    }
    // [처리] 존재하는 모든 cctv처리를 거친 후 최종적인 사각지대 찾는 메소드
    private void makeTotalRoom(String[][] arr) {
        boolean[][] tTemp = new boolean[totalRoom.length][totalRoom[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j].equals("0")) tTemp[i][j] = true;
                totalRoom[i][j] &= tTemp[i][j];
            }
        }
    }
    // [출력]
    private void printResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        for (int i = 0; i < totalRoom.length; i++) {
            for (int j = 0; j < totalRoom[i].length; j++) {
                if(totalRoom[i][j]) count++;
            }
        }
        bw.append(count + "");
        bw.flush();
        bw.close();
    }
}

