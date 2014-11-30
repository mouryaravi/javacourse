import junit.framework.TestCase;

/**
 * Created by ravi on 10/30/14.
 */
public class UserScalabilityTest extends TestCase {
  long prevTime, currentTime, diff;

  //@Before
  public void clearAllUsers() {
    User.deleteUsers();
  }

  public void testValidateUserFrom1000Users() {
    for (int idx = 0; idx < 100000; idx++) {
      User user = new User("ravi-" + idx, "pass");
      user.save();
    }
    User user = new User("ravi-" + 40000, "pass");
    user.readAllUsersIntoMap();
    startTiming();
    System.out.println("Is user valid: " + user.isValidFromMap());
    endTimeAndPrint();
  }

  public void startTiming() {
    prevTime = System.nanoTime();
  }
  public void endTimeAndPrint() {
    currentTime = System.nanoTime();
    diff = currentTime - prevTime;
    System.out.println("Total time: " + diff + " ns");
  }
}
