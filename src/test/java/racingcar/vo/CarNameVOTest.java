package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameVOTest {
    @DisplayName("유효한 이름으로 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "a", "12345"})
    void createWithValidName(String name) {
        // when
        CarNameVO carName = new CarNameVO(name);

        // then
        assertThat(carName.getValue()).isEqualTo(name);
    }

    @DisplayName("이름 앞뒤 공백을 제거한다")
    @Test
    void trimWhitespace() {
        // given
        String nameWithWhitespace = "  pobi  ";

        // when
        CarNameVO carName = new CarNameVO(nameWithWhitespace);

        // then
        assertThat(carName.getValue()).isEqualTo("pobi");
    }

    @DisplayName("null 이름은 예외가 발생한다")
    @Test
    void throwExceptionWhenNull() {
        // when & then
        assertThatThrownBy(() -> new CarNameVO(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 이름은 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void throwExceptionWhenBlank(String name) {
        // when & then
        assertThatThrownBy(() -> new CarNameVO(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("5자를 초과하는 이름은 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi12", "abcdef", "123456", "가나다라마바"})
    void throwExceptionWhenTooLong(String name) {
        // when & then
        assertThatThrownBy(() -> new CarNameVO(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정확히 6자인 이름은 예외가 발생한다")
    @Test
    void throwExceptionWhenExactlySixCharacters() {
        // when & then
        assertThatThrownBy(() -> new CarNameVO("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}