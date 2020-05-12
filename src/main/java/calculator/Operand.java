package calculator;

import java.util.Objects;

public class Operand {
    private final int value;

    private Operand(int value) {
        this.value = value;
    }
    public static Operand of(int value) {
        return new Operand(value);
    }

    public static Operand of(String value) {
        validateNullOrEmpty(value);
        return new Operand(convertStringToInt(value));
    }

    private static int convertStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자는 숫자로 입력해주세요." + value);
        }
    }

    private static void validateNullOrEmpty(String value) {
        if(Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("Null 또는 공백 문자는 피연산자가 될 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
