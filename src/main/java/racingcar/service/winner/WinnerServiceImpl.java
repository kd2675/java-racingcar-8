package racingcar.service.winner;

import racingcar.vo.CarListVO;
import racingcar.vo.CarVO;

import java.util.ArrayList;
import java.util.List;

public class WinnerServiceImpl implements WinnerService {
    @Override
    public List<String> determineWinners(CarListVO carListVO) {
        int maxPosition = findMaxPosition(carListVO);
        return findWinnerNames(carListVO, maxPosition);
    }

    private int findMaxPosition(CarListVO carListVO) {
        int max = 0;
        for (CarVO car : carListVO.getCarList()) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<String> findWinnerNames(CarListVO carListVO, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (CarVO car : carListVO.getCarList()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
