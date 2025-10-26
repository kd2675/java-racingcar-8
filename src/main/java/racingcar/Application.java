package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.input.InputServiceImpl;
import racingcar.service.move.RandomMoveService;
import racingcar.service.race.RaceServiceImpl;
import racingcar.service.winner.WinnerServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController controller = new RacingGameController(
                new InputServiceImpl(),
                new RandomMoveService(),
                new RaceServiceImpl(),
                new WinnerServiceImpl()
        );

        controller.startGame();
    }
}
