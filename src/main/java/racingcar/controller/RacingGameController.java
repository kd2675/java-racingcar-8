package racingcar.controller;

import racingcar.io.Output;
import racingcar.service.input.InputService;
import racingcar.service.move.MoveService;
import racingcar.service.race.RaceServiceImpl;
import racingcar.service.winner.WinnerService;
import racingcar.vo.CarListVO;
import racingcar.vo.RoundCountVO;

import java.util.List;

public record RacingGameController(InputService inputService, MoveService moveService, RaceServiceImpl raceService,
                                   WinnerService winnerService) {
    public void startGame() {
        try {
            List<String> carNames = inputService.getCarNames();
            CarListVO carListVO = new CarListVO(carNames);

            RoundCountVO roundCountVO = inputService.getRoundCount();

            executeRounds(carListVO, roundCountVO.getValue());
            winnerOutput(carListVO);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void executeRounds(CarListVO carListVO, int roundCount) {
        Output.printResultMessage();

        for (int i = 0; i < roundCount; i++) {
            executeRound(carListVO);
            Output.printRoundResult(carListVO);
        }
    }

    private void executeRound(CarListVO carListVO) {
        int carCount = carListVO.getCarList().size();
        List<Integer> randomValues = moveService.getMoveValues(carCount);
        raceService.executeRound(carListVO, randomValues);
    }

    private void winnerOutput(CarListVO carListVO) {
        List<String> winners = winnerService.determineWinners(carListVO);
        Output.printWinners(winners);
    }
}
