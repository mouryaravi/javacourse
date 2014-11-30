import junit.framework.TestCase;

public class RockPaperScissorsTest extends TestCase {
  protected RockPaperScissors rps = null;
  static final String ROCK_STR = "Rock";
  static final String PAPER_STR = "Paper";
  static final String SCISSORS_STR = "Scissors";

  protected void setUp(){
    rps = new RockPaperScissors();
  }
}
