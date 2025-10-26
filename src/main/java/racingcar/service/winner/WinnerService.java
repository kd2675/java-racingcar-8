package racingcar.service.winner;

import racingcar.vo.CarListVO;

import java.util.List;

public interface WinnerService {
    List<String> determineWinners(CarListVO carListVO);
}
