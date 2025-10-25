package racingcar.io;

import racingcar.vo.CarListVO;
import racingcar.vo.CarVO;

import java.util.List;

public class Output {
    public static void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(CarListVO carListVO) {
        for (CarVO car : carListVO.getCarList()) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private static void printCarStatus(CarVO car) {
        System.out.println(car.getName() + " : " + car.getPositionString());
    }
}
