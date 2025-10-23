package racingcar.vo;

public class RoundCountVO {
    private final int value;

    public RoundCountVO(String input) {
        validateNotNull(input);
        validateNotBlank(input);
        int parsedValue = parseToInt(input);
        validatePositive(parsedValue);

        this.value = parsedValue;
    }

    public int getValue() {
        return value;
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("시도 횟수는 null일 수 없습니다.");
        }
    }

    private void validateNotBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
