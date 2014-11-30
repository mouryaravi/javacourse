import junit.framework.TestCase;

/**
 * Created by ravi on 10/29/14.
 */
public class CoinTest extends TestCase {

  public void testGetWinnerFromTwo() {
    Person p1 = new Person("p1", "H");
    Person p2 = new Person("p2", "T");
    FlipCoinGame game = new FlipCoinGame();
    game.result = "T";
    String name = game.pickWinnerFromTwo(p1, p2);
    assertEquals(name, p2.name);
  }


}

