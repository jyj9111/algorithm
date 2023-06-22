package study.string;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        // Optional
        Optional<String> optionalValue = Optional.ofNullable(null/* null이 반환될 수 있는 메소드 */);

        if (optionalValue.isPresent()) {  // 데이터를 가지고 있을 때
            System.out.println("Value is present: " + optionalValue.get());
        } else {  // 데이터가 존재하지 않을 때
            System.out.println("Value is not present");
        }
    }

}
