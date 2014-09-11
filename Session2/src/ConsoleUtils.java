import java.io.BufferedReader;
import java.io.Console;

/**
 * Created by ravi on 10/09/14.
 */
public class ConsoleUtils {

  public static String getInputFromUser() {
   return System.console().readLine();
  }
}
