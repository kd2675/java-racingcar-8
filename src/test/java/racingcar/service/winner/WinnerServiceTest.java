package racingcar.service.winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarListVO;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerServiceTest {
    private WinnerService winnerService;

    @BeforeEach
    void setUp() {
        winnerService = new WinnerServiceImpl();
    }

    @DisplayName("단독 우승자를 결정한다")
    @Test
    void winner() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        CarListVO carListVO = new CarListVO(carNames);
        carListVO.moveAll(Arrays.asList(4, 3, 3));
        carListVO.moveAll(Arrays.asList(4, 3, 4));
        carListVO.moveAll(Arrays.asList(4, 4, 3));

        // when
        List<String> winners = winnerService.determineWinners(carListVO);

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("pobi");
    }

    @DisplayName("공동 우승자를 결정한다")
    @Test
    void winnerWith() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        CarListVO carListVO = new CarListVO(carNames);
        carListVO.moveAll(Arrays.asList(4, 4, 3));
        carListVO.moveAll(Arrays.asList(4, 4, 3));

        // when
        List<String> winners = winnerService.determineWinners(carListVO);

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @DisplayName("모든 자동차가 우승자일 수 있다")
    @Test
    void winnerAll() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        CarListVO carListVO = new CarListVO(carNames);
        carListVO.moveAll(Arrays.asList(3, 3, 3));

        // when
        List<String> winners = winnerService.determineWinners(carListVO);

        // then
        assertThat(winners).hasSize(3);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @DisplayName("이동하지 않은 경우에도 우승자를 결정한다")
    @Test
    void winnerNoMove() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni");
        CarListVO carListVO = new CarListVO(carNames);

        // when
        List<String> winners = winnerService.determineWinners(carListVO);

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

}