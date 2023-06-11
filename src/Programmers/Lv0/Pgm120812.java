package Programmers.Lv0;

public class Pgm120812 { // 최빈값 구하기
    public int solution(int[] array) {
        int[] count = new int[1001];

        for(int i : array) {
            count[i]++;
        }
        int max = -1;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if(i != idx && count[i] == max) return -1;
        }
        return idx;
    }

    public static void main(String[] args) {
        Pgm120812 pg = new Pgm120812();
        int[] array = {1, 2, 1, 2};
        System.out.println(pg.solution(array));
    }
}
