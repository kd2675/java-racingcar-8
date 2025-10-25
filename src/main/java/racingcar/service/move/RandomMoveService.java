package racingcar.service.move;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomMoveService implements MoveService {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    @Override
    public List<Integer> getMoveValues(int count) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(generateRandomValue());
        }

        return result;
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
