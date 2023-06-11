package Programmers;

public class ColatzConjecture {
    public static int solution(int num) {
        int answer = 0;
        int count = 0;
        long lNum = (long) num;
        if (lNum == 1) {
            answer = 0;
        } else {
            while (!(lNum == 1)) {

                if (lNum % 2 == 0) {
                    lNum /= 2;
                    count++;
                } else {
                    lNum = (lNum * 3) + 1;
                    count++;
                }
                if (count == 500) {
                    answer = -1;
                    break;
                } else {
                    answer = count;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = 0;
        result = solution(626331);
        System.out.println(result);

    }
}
