package racingcar.service.race;

import racingcar.vo.CarListVO;

import java.util.List;

public interface RaceService {
    void executeRound(CarListVO carListVO, List<Integer> randomValues);
}
