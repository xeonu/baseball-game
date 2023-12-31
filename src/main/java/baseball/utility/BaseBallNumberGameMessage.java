package baseball.utility;

public class BaseBallNumberGameMessage {

  public static void printRequestNumberInput() {
    System.out.print("숫자를 입력해주세요 : ");
  }

  public static void printVictory() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  public static void printRestartOrExit() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  }

  public static void printOnlyStrikeCount(int strike) {
    System.out.println(strike + "스트라이크");
  }

  public static void printOnlyBallCount(int ball) {
    System.out.println(ball + "볼");
  }

  public static void printNothing() {
    System.out.println("낫싱");
  }

  public static void printBallAndStrike(int ball, int strike) {
    System.out.println(ball + "볼 " + strike + "스트라이크");
  }
}
