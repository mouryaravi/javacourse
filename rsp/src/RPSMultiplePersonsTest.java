import java.util.*;

/**
 * Created by ravi on 11/30/14.
 */
public class RPSMultiplePersonsTest extends RockPaperScissorsTest {

  public void fooTestDecideWinnerFromTwo() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR});
    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    assertEquals(p1.name, rps.decideWinnerFromMultiple(persons));
  }

  public void fooTestDecideWinnerFromFourWithRS_SP_PR_RR() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, SCISSORS_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, PAPER_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{PAPER_STR, ROCK_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{ROCK_STR, ROCK_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    assertEquals(p3.name, rps.decideWinnerFromMultiple(persons));
  }

  public void fooTestDecideWinnerFromEight() {
    PersonWithMultipleChoices p1 = new PersonWithMultipleChoices("one", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR});
    PersonWithMultipleChoices p2 = new PersonWithMultipleChoices("two", new String[]{SCISSORS_STR, PAPER_STR, SCISSORS_STR});
    PersonWithMultipleChoices p3 = new PersonWithMultipleChoices("three", new String[]{PAPER_STR, ROCK_STR, SCISSORS_STR});
    PersonWithMultipleChoices p4 = new PersonWithMultipleChoices("four", new String[]{ROCK_STR, ROCK_STR, PAPER_STR});

    PersonWithMultipleChoices p5 = new PersonWithMultipleChoices("five", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR});
    PersonWithMultipleChoices p6 = new PersonWithMultipleChoices("six", new String[]{PAPER_STR, PAPER_STR, ROCK_STR});
    PersonWithMultipleChoices p7 = new PersonWithMultipleChoices("seven", new String[]{SCISSORS_STR, ROCK_STR, SCISSORS_STR});
    PersonWithMultipleChoices p8 = new PersonWithMultipleChoices("eight", new String[]{ROCK_STR, ROCK_STR, PAPER_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);

    persons.add(p5);
    persons.add(p6);
    persons.add(p7);
    persons.add(p8);

    assertEquals(p6.name, rps.decideWinnerFromMultiple(persons));
  }

  public void fooTestInvalidPersonsList() {
    int count = 9;
    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    for (int idx = 0; idx < count; idx++) {
      PersonWithMultipleChoices p = new PersonWithMultipleChoices("name" + idx, new String[]{ROCK_STR, SCISSORS_STR,
          PAPER_STR});
      persons.add(p);
    }
    assertNull(rps.decideWinnerFromMultiple(persons));
  }

  public void fooTestInvalidChoicesList() {
    int count = 16;
    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    for (int idx = 0; idx < count; idx++) {
      PersonWithMultipleChoices p = new PersonWithMultipleChoices("name" + idx, new String[]{ROCK_STR, SCISSORS_STR});
      persons.add(p);
    }
    assertNull(rps.decideWinnerFromMultiple(persons));
  }

  public void fooTestDecideWinnerFrom16() {
    HashMap<String, String[]> personsWithChoices = new LinkedHashMap<String, String[]>();
    personsWithChoices.put("one", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("two", new String[]{SCISSORS_STR, PAPER_STR, SCISSORS_STR, PAPER_STR});
    personsWithChoices.put("three", new String[]{PAPER_STR, ROCK_STR, SCISSORS_STR, ROCK_STR});
    personsWithChoices.put("four", new String[]{ROCK_STR, ROCK_STR, PAPER_STR, ROCK_STR});
    personsWithChoices.put("five", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("six", new String[]{PAPER_STR, PAPER_STR, ROCK_STR, SCISSORS_STR});
    personsWithChoices.put("seven", new String[]{SCISSORS_STR, ROCK_STR, SCISSORS_STR, PAPER_STR});
    personsWithChoices.put("eight",  new String[]{ROCK_STR, ROCK_STR, PAPER_STR, ROCK_STR});

    personsWithChoices.put("nine", new String[]{SCISSORS_STR, PAPER_STR, ROCK_STR, SCISSORS_STR});
    personsWithChoices.put("ten", new String[]{ROCK_STR, ROCK_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("eleven", new String[]{PAPER_STR, SCISSORS_STR, ROCK_STR, ROCK_STR});
    personsWithChoices.put("twelve", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("thirteen", new String[]{PAPER_STR, SCISSORS_STR, ROCK_STR, SCISSORS_STR});
    personsWithChoices.put("fourteen", new String[]{SCISSORS_STR, SCISSORS_STR, PAPER_STR, ROCK_STR});
    personsWithChoices.put("fifteen", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("sixteen", new String[]{PAPER_STR, ROCK_STR, ROCK_STR, SCISSORS_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    for (Map.Entry<String, String[]> entry: personsWithChoices.entrySet()) {
      persons.add(new PersonWithMultipleChoices(entry.getKey(), entry.getValue()));
    }
    assertEquals("six", rps.decideWinnerFromMultiple(persons));
  }

  public void testDecideWinnerFrom32() {
    HashMap<String, String[]> personsWithChoices = new LinkedHashMap<String, String[]>();
    personsWithChoices.put("1", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, SCISSORS_STR, PAPER_STR});
    personsWithChoices.put("2", new String[]{SCISSORS_STR, PAPER_STR, SCISSORS_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("3", new String[]{PAPER_STR, ROCK_STR, SCISSORS_STR, ROCK_STR, ROCK_STR});
    personsWithChoices.put("4", new String[]{ROCK_STR, ROCK_STR, PAPER_STR, ROCK_STR, ROCK_STR});
    personsWithChoices.put("5", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("6", new String[]{PAPER_STR, PAPER_STR, ROCK_STR, SCISSORS_STR, SCISSORS_STR});
    personsWithChoices.put("7", new String[]{SCISSORS_STR, ROCK_STR, SCISSORS_STR, PAPER_STR, ROCK_STR});
    personsWithChoices.put("8",  new String[]{ROCK_STR, ROCK_STR, PAPER_STR, ROCK_STR, SCISSORS_STR});

    personsWithChoices.put("9", new String[]{SCISSORS_STR, PAPER_STR, ROCK_STR, SCISSORS_STR, ROCK_STR});
    personsWithChoices.put("10", new String[]{ROCK_STR, ROCK_STR, PAPER_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("11", new String[]{PAPER_STR, SCISSORS_STR, ROCK_STR, ROCK_STR, PAPER_STR});
    personsWithChoices.put("12", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("13", new String[]{PAPER_STR, SCISSORS_STR, ROCK_STR, SCISSORS_STR, ROCK_STR});
    personsWithChoices.put("14", new String[]{SCISSORS_STR, SCISSORS_STR, PAPER_STR, ROCK_STR, SCISSORS_STR});
    personsWithChoices.put("15", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("16", new String[]{PAPER_STR, ROCK_STR, ROCK_STR, SCISSORS_STR, ROCK_STR});

    personsWithChoices.put("17", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, SCISSORS_STR, ROCK_STR});
    personsWithChoices.put("18", new String[]{SCISSORS_STR, PAPER_STR, SCISSORS_STR, PAPER_STR, PAPER_STR});
    personsWithChoices.put("19", new String[]{ROCK_STR, ROCK_STR, SCISSORS_STR, ROCK_STR, SCISSORS_STR});
    personsWithChoices.put("20", new String[]{PAPER_STR, ROCK_STR, PAPER_STR, ROCK_STR, PAPER_STR});
    personsWithChoices.put("21", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("22", new String[]{SCISSORS_STR, PAPER_STR, ROCK_STR, SCISSORS_STR, PAPER_STR});
    personsWithChoices.put("23", new String[]{SCISSORS_STR, ROCK_STR, SCISSORS_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("24",  new String[]{ROCK_STR, ROCK_STR, ROCK_STR, ROCK_STR, ROCK_STR});

    personsWithChoices.put("25", new String[]{SCISSORS_STR, PAPER_STR, ROCK_STR, SCISSORS_STR, SCISSORS_STR});
    personsWithChoices.put("26", new String[]{PAPER_STR, ROCK_STR, PAPER_STR, PAPER_STR, ROCK_STR});
    personsWithChoices.put("27", new String[]{PAPER_STR, SCISSORS_STR, ROCK_STR, ROCK_STR, PAPER_STR});
    personsWithChoices.put("28", new String[]{SCISSORS_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, SCISSORS_STR});
    personsWithChoices.put("29", new String[]{PAPER_STR, PAPER_STR, ROCK_STR, SCISSORS_STR, PAPER_STR});
    personsWithChoices.put("30", new String[]{ROCK_STR, SCISSORS_STR, PAPER_STR, ROCK_STR, ROCK_STR});
    personsWithChoices.put("31", new String[]{SCISSORS_STR, SCISSORS_STR, PAPER_STR, PAPER_STR, ROCK_STR});
    personsWithChoices.put("32", new String[]{PAPER_STR, ROCK_STR, ROCK_STR, SCISSORS_STR, SCISSORS_STR});

    List<PersonWithMultipleChoices> persons = new ArrayList<PersonWithMultipleChoices>();
    for (Map.Entry<String, String[]> entry: personsWithChoices.entrySet()) {
      persons.add(new PersonWithMultipleChoices(entry.getKey(), entry.getValue()));
    }

    assertEquals("31", rps.decideWinnerFromMultiple(persons));
  }



}
