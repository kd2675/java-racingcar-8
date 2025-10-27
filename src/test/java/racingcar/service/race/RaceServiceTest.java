package racingcar.service.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarListVO;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceServiceImpl();
    }

    @DisplayName("한 라운드를 실행한다")
    @Test
    void roundOne() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni");
        CarListVO carListVO = new CarListVO(carNames);
        List<Integer> randomValues = Arrays.asList(4, 5);

        // when
        raceService.executeRound(carListVO, randomValues);

        // then
        assertThat(carListVO.getCarList().get(0).getPosition()).isEqualTo(1);
        assertThat(carListVO.getCarList().get(1).getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값에 따라 차등적으로 이동한다")
    @Test
    void roundWithRandom() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        CarListVO carListVO = new CarListVO(carNames);
        List<Integer> randomValues = Arrays.asList(4, 3, 9);

        // when
        raceService.executeRound(carListVO, randomValues);

        // then
        assertThat(carListVO.getCarList().get(0).getPosition()).isEqualTo(1);
        assertThat(carListVO.getCarList().get(1).getPosition()).isEqualTo(0);
        assertThat(carListVO.getCarList().get(2).getPosition()).isEqualTo(1);
    }

    @DisplayName("여러 라운드를 실행한다")
    @Test
    void roundMultiple() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni");
        CarListVO carListVO = new CarListVO(carNames);

        // when
        raceService.executeRound(carListVO, Arrays.asList(4, 5));
        raceService.executeRound(carListVO, Arrays.asList(3, 4));
        raceService.executeRound(carListVO, Arrays.asList(9, 3));

        // then
        assertThat(carListVO.getCarList().get(0).getPosition()).isEqualTo(2);
        assertThat(carListVO.getCarList().get(1).getPosition()).isEqualTo(2);
    }

}