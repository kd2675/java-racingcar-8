package racingcar.service.move;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoveServiceTest {
    private MoveService moveService;

    @BeforeEach
    void setUp() {
        moveService = new RandomMoveService();
    }

    @DisplayName("요청한 개수만큼 랜덤 값을 생성한다")
    @Test
    void moveRandomValues() {
        // given
        int count = 5;

        // when
        List<Integer> randomValues = moveService.getMoveValues(count);

        // then
        assertThat(randomValues).hasSize(count);
    }

    @DisplayName("생성된 랜덤 값은 0~9 범위이다")
    @Test
    void moveRandomValuesRange() {
        // given
        int count = 100;

        // when
        List<Integer> randomValues = moveService.getMoveValues(count);

        // then
        assertThat(randomValues).allMatch(value -> value >= 0 && value <= 9);
    }

    @DisplayName("0개의 랜덤 값을 요청하면 빈 리스트를 반환한다")
    @Test
    void moveEmpty() {
        // given
        int count = 0;

        // when
        List<Integer> randomValues = moveService.getMoveValues(count);

        // then
        assertThat(randomValues).isEmpty();
    }

    @DisplayName("1개의 랜덤 값을 요청하면 1개를 반환한다")
    @Test
    void moveOne() {
        // given
        int count = 1;

        // when
        List<Integer> randomValues = moveService.getMoveValues(count);

        // then
        assertThat(randomValues).hasSize(1);
        assertThat(randomValues.get(0)).isBetween(0, 9);
    }

}