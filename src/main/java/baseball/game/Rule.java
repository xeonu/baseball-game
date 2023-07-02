package baseball.game;

public class Rule {

  private int countOfNumbers;
  private int minNumber;
  private int maxNumber;

  public Rule(int countOfNumbers, int minNumber, int maxNumber) {
    this.countOfNumbers = countOfNumbers;
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  public int getCountOfNumbers() {
    return countOfNumbers;
  }

  public int getMinNumber() {
    return minNumber;
  }

  public int getMaxNumber() {
    return maxNumber;
  }
}