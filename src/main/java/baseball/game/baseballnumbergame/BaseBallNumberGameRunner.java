package baseball.game.baseballnumbergame;


import static baseball.utility.Utility.numberStringToIntList;

import baseball.game.NumberGameRunner;
import baseball.game.Rule;
import baseball.game.Score;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumberGameRunner implements NumberGameRunner {

  private Rule rule;
  private List<Integer> randomNumbers;

  public BaseBallNumberGameRunner(Rule rule) {
    randomNumbers = new ArrayList<>();
    this.rule = rule;
  }

  @Override
  public void init() {
    generateRandomNumbers();
  }

  @Override
  public Score runGame(String input) {
    verifyInput(input);
    Score score = calculateScore(input);
    return score;
  }

  public void generateRandomNumbers() {
    Set<Integer> uniqueNumbers = new HashSet<>();
    while (uniqueNumbers.size() < rule.getCountOfNumbers()) {
      int randomNumber = Randoms.pickNumberInRange(rule.getMinNumber(), rule.getMaxNumber());
      uniqueNumbers.add(randomNumber);
    }
    randomNumbers = new ArrayList<>(uniqueNumbers);
  }

  private void verifyInput(String input) {
    List<Integer> numbers = numberStringToIntList(input, rule);
    verifyNumberCount(input);
    verifyNumbersInRange(numbers);
    verifyNumbersUnique(numbers);
  }

  private Score calculateScore(String input) {
    List<Integer> numbers = numberStringToIntList(input, rule);
    int exactMatchCount = 0;
    int matchButMisplacedCount = 0;

    for (int i = 0; i < rule.getCountOfNumbers(); i++) {
      if (randomNumbers.contains(numbers.get(i))) {
        if (randomNumbers.get(i).equals(numbers.get(i))) {
          exactMatchCount++;
        } else {
          matchButMisplacedCount++;
        }
      }
    }

    Score score = new Score(exactMatchCount, matchButMisplacedCount);
    return score;
  }

  private void verifyNumberCount(String input) {
    if (isValidNumberCount(input)) {
      throw new IllegalArgumentException();
    }
  }

  private void verifyNumbersInRange(List<Integer> numbers) {
    for (int number : numbers) {
      if (!isNumberInRange(number)) {
        throw new IllegalArgumentException();
      }
    }
  }

  private void verifyNumbersUnique(List<Integer> numbers) {
    if (!isNumbersUnique(numbers)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isValidNumberCount(String input) {
    return input.length() != rule.getCountOfNumbers();
  }

  private boolean isNumberInRange(int number) {
    return (number >= rule.getMinNumber()) && (number <= rule.getMaxNumber());
  }

  private boolean isNumbersUnique(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    return numbers.size() == uniqueNumbers.size();
  }
}
