package baseball.game.baseballnumbergame;

import static baseball.game.GameResult.FAIL;
import static baseball.game.GameResult.SUCCESS;
import static baseball.utility.BaseBallNumberGameMessage.printBallAndStrike;
import static baseball.utility.BaseBallNumberGameMessage.printNothing;
import static baseball.utility.BaseBallNumberGameMessage.printOnlyBallCount;
import static baseball.utility.BaseBallNumberGameMessage.printOnlyStrikeCount;

import baseball.game.GameResult;
import baseball.game.NumberGameResultAnalyzer;
import baseball.game.Rule;
import baseball.game.Score;

public class BaseBallNumberGameResultAnalyzer implements NumberGameResultAnalyzer {

  private final Rule rule;

  public BaseBallNumberGameResultAnalyzer(Rule rule) {
    this.rule = rule;
  }

  @Override
  public GameResult analyze(Score score) {
    int total = rule.getCountOfNumbers();
    int exactMatchCount = score.getExactMatchCount();
    int matchButMisplacedCount = score.getMatchButMisplacedCount();

    if (total == exactMatchCount) {
      printOnlyStrikeCount(exactMatchCount);
      return SUCCESS;
    }

    if (exactMatchCount == 0 && matchButMisplacedCount == 0) {
      printNothing();
      return FAIL;
    }

    if (exactMatchCount == 0) {
      printOnlyBallCount(matchButMisplacedCount);
      return FAIL;
    }

    if (matchButMisplacedCount == 0) {
      printOnlyStrikeCount(exactMatchCount);
      return FAIL;
    }

    printBallAndStrike(matchButMisplacedCount, exactMatchCount);
    return FAIL;
  }
}
