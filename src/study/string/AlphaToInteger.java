package study.string;

public class AlphaToInteger {
    // 숫자로만 이루어진 문자열 value 가정
    // 각 글자를 숫자 데이터로 해석한 뒤
    // -48 하면 숫자가 된다.
    public int atoi(String value) {
        int result = 0;
        boolean negative = false;
        int i = 0;
        if(value.charAt(i) == '-') {
            negative =true;
            i++;
        }
        for (; i < value.length(); i++) {
            result *= 10;
            result += value.charAt(i) - '0';
        }

        return negative ? -result : result;
    }
    public static void main(String[] args) {
        System.out.println(new AlphaToInteger().atoi("-1234"));

    }
}
