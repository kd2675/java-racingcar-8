package racingcar.vo;

import java.util.ArrayList;
import java.util.List;

public class CarListVO {
    private final List<CarVO> carVOList;

    public CarListVO(List<String> carNames) {
        validateNotEmpty(carNames);
        this.carVOList = initCarList(carNames);
    }

    private void validateNotEmpty(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록은 비어있을 수 없습니다.");
        }
    }

    public List<CarVO> getCarList() {
        return carVOList;
    }

    private List<CarVO> initCarList(List<String> carNames) {
        List<CarVO> carVOList = new ArrayList<>();
        for (String name : carNames) {
            carVOList.add(new CarVO(name));
        }
        return carVOList;
    }

    public void moveAll(List<Integer> randomValues) {
        for (int i = 0; i < carVOList.size(); i++) {
            carVOList.get(i).moveForward(randomValues.get(i));
        }
    }
}
