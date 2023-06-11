package Programmers;
//약수의 합
public class Programmers12928 {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            if(n % i == 0)
                answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        int result = solution(5);
        System.out.println(result);
    }
}
