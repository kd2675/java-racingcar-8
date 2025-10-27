package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarVOTest {
    @DisplayName("랜덤 값이 4 이상이면 자동차가 전진한다")
    @Test
    void carForward() {
        // given
        CarVO car = new CarVO("pobi");

        // when
        car.moveForward(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 4 미만이면 자동차가 정지한다")
    @Test
    void carStop() {
        // given
        CarVO car = new CarVO("pobi");

        // when
        car.moveForward(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}