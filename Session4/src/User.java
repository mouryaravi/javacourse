import java.util.HashMap;
import java.util.List;

/**
 * Created by ravi on 10/09/14.
 */
public class User {
  private String username;
  private String password;
  private HashMap<String, String> map = new HashMap<String, String>();
  public String getUsername() {
    return this.username;
  }


  private static final String USERS_FILE = "./users.txt";

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void save() {
    FileWriter fileWriter = new FileWriter(USERS_FILE);
    fileWriter.addLine(username + ":" + password);
  }

  public static void deleteUsers() {
    new FileWriter(USERS_FILE).deleteFile();
  }

  public boolean isValid() {
    FileReader fileReader = new FileReader(USERS_FILE);
    List<String> users = fileReader.getLines();
    for (String user: users) {
      if ((username + ":" + password).equals(user)) {
        return true;
      }
    }
    return false;
  }

  public void readAllUsersIntoMap() {
    FileReader fileReader = new FileReader(USERS_FILE);
    List<String> users = fileReader.getLines();
    for (String user: users) {
      String[] userArray = user.split(":");
      map.put(userArray[0], userArray[1]);
    }
  }

  public boolean isValidFromMap() {
    String pass1 = map.get(username);
    if (password.equals(pass1)) {
      return true;
    }
    return false;
  }

}
