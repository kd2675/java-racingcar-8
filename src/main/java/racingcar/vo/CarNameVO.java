package racingcar.vo;

public class CarNameVO {
    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public CarNameVO(String value) {
        validateNotNull(value);
        validateNotBlank(value);
        validateLength(value);

        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    private void validateNotNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }
    }

    private void validateNotBlank(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
