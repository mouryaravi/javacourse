public class RockPaperScissorsTestForTwoPersons extends RockPaperScissorsTest {

  public void testDecideWinnerFromTwoWithRS() throws Exception {
    Person p1 = new Person("one", ROCK_STR);
    Person p2 = new Person("two", SCISSORS_STR);

    assertEquals(p1.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithSR() throws Exception {
    Person p1 = new Person("one", SCISSORS_STR);
    Person p2 = new Person("two", ROCK_STR);

    assertEquals(p2.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithRP() throws Exception {
    Person p1 = new Person("one", ROCK_STR);
    Person p2 = new Person("two", PAPER_STR);

    assertEquals(p2.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithPR() throws Exception {
    Person p1 = new Person("one", PAPER_STR);
    Person p2 = new Person("two", ROCK_STR);

    assertEquals(p1.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithPS() throws Exception {
    Person p1 = new Person("one", PAPER_STR);
    Person p2 = new Person("two", SCISSORS_STR);

    assertEquals(p2.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithSP() throws Exception {
    Person p1 = new Person("one", SCISSORS_STR);
    Person p2 = new Person("two", PAPER_STR);

    assertEquals(p1.name, rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithOneInvalidChoice() throws Exception {
    Person p1 = new Person("one", "INVALID");
    Person p2 = new Person("two", PAPER_STR);

    assertNull(rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithOneBothInvalidChoices() throws Exception {
    Person p1 = new Person("one", "INVALID1");
    Person p2 = new Person("two", "INVALID2");

    assertNull(rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithSS() throws Exception {
    Person p1 = new Person("one", SCISSORS_STR);
    Person p2 = new Person("two", SCISSORS_STR);

    String winner = rps.decideWinnerFromTwo(p1, p2);
    assertTrue(p1.name.equals(winner) || p2.name.equals(winner));
  }

  public void testDecideWinnerFromTwoWithRR() throws Exception {
    Person p1 = new Person("one", ROCK_STR);
    Person p2 = new Person("two", ROCK_STR);

    String winner = rps.decideWinnerFromTwo(p1, p2);
    assertTrue(p1.name.equals(winner) || p2.name.equals(winner));
  }

  public void testDecideWinnerFromTwoWithPP() throws Exception {
    Person p1 = new Person("one", PAPER_STR);
    Person p2 = new Person("two", PAPER_STR);

    String winner = rps.decideWinnerFromTwo(p1, p2);
    assertTrue(p1.name.equals(winner) || p2.name.equals(winner));
  }

  public void testDecideWinnerFromTwoWithNullChoiceForFirst() throws Exception {
    Person p1 = new Person("one", null);
    Person p2 = new Person("two", PAPER_STR);

    assertNull(rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithNullChoiceForSecond() throws Exception {
    Person p1 = new Person("one", PAPER_STR);
    Person p2 = new Person("two", null);

    assertNull(rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithNullChoices() throws Exception {
    Person p1 = new Person("one", null);
    Person p2 = new Person("two", null);

    assertNull(rps.decideWinnerFromTwo(p1, p2));
  }

  public void testDecideWinnerFromTwoWithNullInputs() throws Exception {
    assertNull(rps.decideWinnerFromTwo(null, null));
  }
}
