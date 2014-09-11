import java.util.List;

/**
 * Created by ravi on 10/09/14.
 */
public class User {
  private String username;
  private String password;
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

}
