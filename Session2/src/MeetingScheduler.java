/**
 * Created by ravi on 11/09/14.
 */
public class MeetingScheduler {
  public static void main(String[] args) {

    if (args.length < 3) {
      System.out.println("Usage: MeetingScheduler <option> <username> <password>");
      return;
    }
    System.out.println(args[0] + ", " + args[1] + ", " + args[2]);
    if (args[0].equals("createUser")) {
      createUser(args[1], args[2]);
    }
    else if (args[0].equals("createMeeting")) {
      createMeeting();
    }
    else {
      System.out.println("Wrong option");
      return;
    }


  }

  static void createUser(String username, String password) {
    User user = new User(username, password);
    user.create();
  }

  static void createMeeting() {
    Meeting meeting = new Meeting();
    meeting.takeMeetingDetails();
    meeting.print();
  }

}
