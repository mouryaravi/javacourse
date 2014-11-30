import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ravi on 11/29/14.
 */
public class RockPaperScissors {
  static final String PAPER_STR = "Paper";
  static final String ROCK_STR = "Rock";
  static final String SCISSORS_STR = "Scissors";

  static HashMap<String, String> iBeatList = new HashMap<String, String>();
  static {
    iBeatList.put(PAPER_STR, ROCK_STR);
    iBeatList.put(ROCK_STR, SCISSORS_STR);
    iBeatList.put(SCISSORS_STR, PAPER_STR);
  }

  public String decideWinnerFromTwo(Person p1, Person p2) {
    try {
      validateInputs(p1, p2);
      Person person = getWinner(p1, p2);
      return (person == null)? null: person.name;
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    }
  }

  private Person getWinner(Person p1, Person p2) {
    if (iBeatList.get(p1.choice).equals(p2.choice)) {
      System.out.println("'" + p1.choice + "' BEATS '" + p2.choice + "'");
      return p1;
    }
    System.out.println("'" + p2.choice + "' BEATS OR SAME AS '" + p1.choice + "'");
    return p2;
  }

  private void validateInputs(Person p1, Person p2) {
    boolean error = false;
    if (p1 == null || p2 == null) {
      error = true;
    }
    else if (p1.choice == null || p1.choice.isEmpty() || p1.name == null || p1.name.isEmpty()) {
      error = true;
    }
    else if (p2.choice == null || p2.choice.isEmpty() || p2.name == null || p2.name.isEmpty()) {
      error = true;
    }
    else if (!isValidChoice(p1.choice) || !isValidChoice(p2.choice)) {
      error = true;
    }
    if (error) {
      throw new IllegalArgumentException("Invalid input");
    }
  }

  private boolean isValidChoice(String choice) {
    if (choice.equals(ROCK_STR) || choice.equals(PAPER_STR) || choice.equals(SCISSORS_STR)) {
      return true;
    }
    return false;
  }

  public String decideWinnerFromMultiple(List<PersonWithMultipleChoices> persons) {
    try {
      validateMultiPersonsInput(persons, null);
      if (persons.size() == 2) {
        PersonWithMultipleChoices winner = getWinnerWithMultipleChoices(persons.get(0), persons.get(1), 0);
        return winner.name;
      }
      PersonWithMultipleChoices winner = decideWinnerFromMultipleRecursive(persons, 0);
      return winner.name;
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    }
  }

  private PersonWithMultipleChoices decideWinnerFromMultipleRecursive(List<PersonWithMultipleChoices> persons, int idx) {
    if (persons.size() == 1) {
      return persons.get(0);
    }
    List<PersonWithMultipleChoices> winners = new ArrayList<PersonWithMultipleChoices>();
    int first = 0, second = 1;
    while (first < persons.size() || second < persons.size()) {
      System.out.println("***** Checking the winner from [" + first + ", " + second + "]" + ", index: " + idx);
      PersonWithMultipleChoices winner = getWinnerWithMultipleChoices(persons.get(first), persons.get(second), idx);
      winners.add(winner);
      first += 2;
      second += 2;
    }
    System.out.println("<=======================================================>");
    return decideWinnerFromMultipleRecursive(winners, idx + 1);
  }

  public String decideWinnerFromFour(List<PersonWithMultipleChoices> persons) {
    try {
      validateMultiPersonsInput(persons, 4);
      PersonWithMultipleChoices winner1 = getWinnerWithMultipleChoices(persons.get(0), persons.get(1), 0);
      PersonWithMultipleChoices winner2 = getWinnerWithMultipleChoices(persons.get(2), persons.get(3), 0);
      PersonWithMultipleChoices winner = getWinnerWithMultipleChoices(winner1, winner2, 1);
      return winner.name;
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    }
  }

  private PersonWithMultipleChoices getWinnerWithMultipleChoices(
      PersonWithMultipleChoices p1, PersonWithMultipleChoices p2, int idx) {
    if (iBeatList.get(p1.choices[idx]).equals(p2.choices[idx])) {
      System.out.println(p1.name +": '" + p1.choices[idx] + "' BEATS " + p2.name + ": '" + p2.choices[idx] + "'");
      return p1;
    }
    System.out.println(p2.name +": '" + p2.choices[idx] + "' BEATS OR SAME AS " + p1.name + ": '" + p1.choices[idx] +
        "'");
    return p2;
  }

  private void validateMultiPersonsInput(List<PersonWithMultipleChoices> persons, Integer count) {
    String msg = "";
    boolean error = false;
    if (persons == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    else if (count == null) {
      count = persons.size();
    }

    if (persons.size() != count) {
      msg = "Persons count: " + persons.size() + ", is not equal to expected count: " + count;
      error = true;
    }
    else if (!powerOfTwo(persons.size())) {
      msg = "Persons count: " + persons.size() + ", is not power of 2";
      error = true;
    }
    else {
      for (PersonWithMultipleChoices person : persons) {
        if (person == null ||
            person.choices == null ||
            person.choices.length < nthPowerOfTwo(count) ||
            person.name == null ||
            person.name.isEmpty() ||
            !areValidChoices(person.choices)) {
          error = true;
          msg = "Person input: " + person.name + ", choices: " + person.choices + " not correct.";
          break;
        }
      }
    }
    if (error) {
      throw new IllegalArgumentException(msg);
    }
  }

  private int nthPowerOfTwo(Integer count) {
    int log2Val = (int) (Math.log(count) / Math.log(2));
    return log2Val;
  }

  private boolean powerOfTwo(int n) {
    return (n & (n - 1)) == 0;
  }

  private boolean areValidChoices(String[] choices) {
    for (String choice: choices) {
      if (!isValidChoice(choice)) {
        return false;
      }
    }
    return true;
  }

}
