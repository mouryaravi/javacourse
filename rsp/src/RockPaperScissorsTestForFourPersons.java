import java.util.ArrayList;
import java.util.List;

public class RockPaperScissorsTestForFourPersons extends RockPaperScissorsTest {
  public void testDecideWinnerFromFourWithRS_SP_PR_RR() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, SCISSORS_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, PAPER_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{PAPER_STR, ROCK_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{ROCK_STR, ROCK_STR});


    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    assertEquals(p3.name, rps.decideWinnerFromFour(persons));
  }

  public void testDecideWinnerFromFourWithRR$SS$RP$PS() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, ROCK_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, SCISSORS_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{ROCK_STR, PAPER_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{PAPER_STR, SCISSORS_STR});


    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    assertEquals(p1.name, rps.decideWinnerFromFour(persons));
  }

  public void testDecideWinnerFromFourWithRR$SS$PP$PR() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, ROCK_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, SCISSORS_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{PAPER_STR, PAPER_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{ROCK_STR, ROCK_STR});


    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    assertEquals(p3.name, rps.decideWinnerFromFour(persons));
  }

  public void testDecideWinnerFromFourWithNullInput() {
    assertNull(rps.decideWinnerFromFour(null));
  }

  public void testDecideWinnerFromFourWithNoPersons() {
    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();

    assertNull(rps.decideWinnerFromFour(persons));
  }

  public void testDecideWinnerFromFourWithOnly2Persons() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, ROCK_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, SCISSORS_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);

      assertNull(rps.decideWinnerFromFour(persons));
  }

  public void testDecideWinnerFromFourWithOnly1Choice() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{ROCK_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{SCISSORS_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    assertNull(rps.decideWinnerFromFour(persons));
  }

}
