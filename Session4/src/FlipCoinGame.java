import java.util.Random;

/**
 * Created by ravi on 10/29/14.
 */
public class FlipCoinGame {
  public String result;

  public String pickWinnerFromTwo(Person p1, Person p2) {
    System.out.println("The result is: " + result);
    if (p1.choice.equalsIgnoreCase(result)) {
      return p1.name;
    }
    if (p2.choice.equalsIgnoreCase(result)) {
      return p2.name;
    }
    return null;
  }


  public String tossACoin() {
    String[] coinValues = {"H", "T"};
    int rand = new Random().nextInt(2);
    return coinValues[rand];
  }


}
