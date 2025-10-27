package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundCountVOTest {

    @DisplayName("정상적인 시도 횟수로 객체를 생성한다")
    @Test
    void round() {
        // given & when
        RoundCountVO roundCountVO = new RoundCountVO("5");

        // then
        assertThat(roundCountVO.getValue()).isEqualTo(5);
    }

    @DisplayName("null 입력 시 예외가 발생한다")
    @Test
    void roundNull() {
        // when & then
        assertThatThrownBy(() -> new RoundCountVO(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 null일 수 없습니다");
    }

    @DisplayName("빈 문자열 입력 시 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void roundEmpty(String input) {
        // when & then
        assertThatThrownBy(() -> new RoundCountVO(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력 시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "a1", "1.5"})
    void roundNotInt(String input) {
        // when & then
        assertThatThrownBy(() -> new RoundCountVO(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다");
    }

    @DisplayName("0 이하의 숫자 입력 시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void RoundMinus(String input) {
        // when & then
        assertThatThrownBy(() -> new RoundCountVO(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수여야 합니다");
    }

    @DisplayName("공백이 포함된 정상 입력은 처리된다")
    @Test
    void RoundWithSpace() {
        // given & when
        RoundCountVO roundCountVO = new RoundCountVO("  5  ");

        // then
        assertThat(roundCountVO.getValue()).isEqualTo(5);
    }
}