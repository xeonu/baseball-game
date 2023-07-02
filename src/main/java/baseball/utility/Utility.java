package baseball.utility;


import baseball.game.Rule;
import java.util.ArrayList;
import java.util.List;

public class Utility {

  public static List<Integer> numberStringToIntList(String number, Rule rule) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < rule.getCountOfNumbers(); i++) {
      char c = number.charAt(i);
      int digit = Character.getNumericValue(c);
      numbers.add(digit);
    }

    return numbers;
  }
}
