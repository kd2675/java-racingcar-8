package racingcar.service.input;

import racingcar.io.Input;
import racingcar.vo.RoundCountVO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputServiceImpl implements InputService {
    private static final String DELIMITER = ",";

    @Override
    public List<String> getCarNames() {
        String input = Input.carNames();
        return parseCarNames(input);
    }

    @Override
    public RoundCountVO getRoundCount() {
        String input = Input.rounds();
        return new RoundCountVO(input);
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
