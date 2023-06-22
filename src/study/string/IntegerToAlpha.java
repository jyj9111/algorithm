package study.string;

public class IntegerToAlpha {
    public String itoa(int value) {
        StringBuilder answer = new StringBuilder();
        boolean negative = false;
        if (value < 0) {
            negative = true;
            value *= -1;
        }

        while (value > 0) {
            char digitChar = (char)(value % 10 + '0');
            answer.append(digitChar);
            value /= 10;
        }
        if(negative) answer.append("-");
        return answer.reverse().toString();
    }
    public static void main(String[] args) {
        IntegerToAlpha itoa = new IntegerToAlpha();
        System.out.println(itoa.itoa(-1234));
    }
}
