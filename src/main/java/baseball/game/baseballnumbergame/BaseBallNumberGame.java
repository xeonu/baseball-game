package baseball.game.baseballnumbergame;

import static baseball.game.GameResult.FAIL;
import static baseball.game.GameResult.SUCCESS;
import static baseball.utility.BaseBallNumberGameConstant.REPLAY_INPUT;
import static baseball.utility.BaseBallNumberGameConstant.STOP_INPUT;
import static baseball.utility.BaseBallNumberGameMessage.printRequestNumberInput;
import static baseball.utility.BaseBallNumberGameMessage.printRestartOrExit;
import static baseball.utility.BaseBallNumberGameMessage.printVictory;

import baseball.game.GameResult;
import baseball.game.NumberGame;
import baseball.game.NumberGameResultAnalyzer;
import baseball.game.NumberGameRunner;
import baseball.game.Rule;
import baseball.game.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallNumberGame implements NumberGame {

  private final NumberGameRunner numberGameRunner;
  private final NumberGameResultAnalyzer numberGameResultAnalyzer;

  public BaseBallNumberGame(Rule rule) {
    this.numberGameRunner = new BaseBallNumberGameRunner(rule);
    this.numberGameResultAnalyzer = new BaseBallNumberGameResultAnalyzer(rule);
  }

  @Override
  public void play() {
    numberGameRunner.init();
    while (true) {
      printRequestNumberInput();
      String input = Console.readLine();

      Score score = numberGameRunner.runGame(input);
      GameResult gameResult = numberGameResultAnalyzer.analyze(score);

      if (gameResult == SUCCESS) {
        printVictory();

        if (!isRetryRequired()) {
          break;
        }
        numberGameRunner.init();
        continue;
      }

      if (gameResult == FAIL) {
        continue;
      }
    }
  }

  private boolean isRetryRequired() {
    printRestartOrExit();
    String input = Console.readLine();
    if (!(input.equals(REPLAY_INPUT) || input.equals(STOP_INPUT))) {
      throw new IllegalArgumentException();
    }
    if (input.equals(REPLAY_INPUT)) {
      return true;
    }
    return false;
  }
}
