package baseball.game;

public class Score {

  private int exactMatchCount;
  private int matchButMisplacedCount;

  public Score(int exactMatchCount, int matchButMisplacedCount) {
    this.exactMatchCount = exactMatchCount;
    this.matchButMisplacedCount = matchButMisplacedCount;
  }

  public int getExactMatchCount() {
    return exactMatchCount;
  }

  public int getMatchButMisplacedCount() {
    return matchButMisplacedCount;
  }
}
