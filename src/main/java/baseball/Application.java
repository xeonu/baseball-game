package baseball;

import static baseball.utility.BaseBallNumberGameConstant.COUNT_OF_NUMBERS;
import static baseball.utility.BaseBallNumberGameConstant.MAX_NUMBER;
import static baseball.utility.BaseBallNumberGameConstant.MIN_NUMBER;

import baseball.game.baseballnumbergame.BaseBallNumberGame;
import baseball.game.NumberGame;
import baseball.game.Rule;

public class Application {

  public static void main(String[] args) {
    Rule rule = new Rule(COUNT_OF_NUMBERS, MIN_NUMBER, MAX_NUMBER);
    NumberGame numberGame = new BaseBallNumberGame(rule);

    numberGame.play();
  }
}