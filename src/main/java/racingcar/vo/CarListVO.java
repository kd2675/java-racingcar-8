package racingcar.vo;

import java.util.ArrayList;
import java.util.List;

public class CarListVO {
    private final List<CarVO> carVOList;

    public CarListVO(List<String> carNames) {
        this.carVOList = initCarList(carNames);
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
