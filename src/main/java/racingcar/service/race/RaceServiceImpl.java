package racingcar.service.race;

import racingcar.vo.CarListVO;

import java.util.List;

public class RaceServiceImpl implements RaceService {
    @Override
    public void executeRound(CarListVO carListVO, List<Integer> randomValues) {
        carListVO.moveAll(randomValues);
    }
}
