package racingcar.service.input;

import racingcar.vo.RoundCountVO;

import java.util.List;

public interface InputService {
    List<String> getCarNames();
    RoundCountVO getRoundCount();
}
