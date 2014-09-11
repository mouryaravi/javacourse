/**
 * Created by ravi on 10/09/14.
 */
public class Scheduler {

  public static void main(String[] args) {
    if (args == null || args.length < 2) {
      System.out.println("Usage: java Scheduler <option> <username> <password>");
      return;
    }
    String option = args[0];
    if (option.equalsIgnoreCase("addUser")) {
      addUser(args);
    }
    else if(option.equalsIgnoreCase("addMeeting")) {
      addMeeting(args);
    }

  }

  private static void addMeeting(String[] args) {
    if (args.length < 3) {
      System.out.println("Enter username and password for adding meeting...");
      return;
    }
    User user = new User(args[1], args[2]);
    if (!user.isValid()) {
      System.out.println("Invalid user credentials");
      return;
    }
    addMeetingWithUser(user);
  }

  private static void addMeetingWithUser(User user) {
    System.out.println("Enter Meeting details:");
    System.out.println("Subject: ");
    String subject = ConsoleUtils.getInputFromUser();
    System.out.println("Starting Time: ");
    String start = ConsoleUtils.getInputFromUser();
    System.out.println("End Time:");
    String end = ConsoleUtils.getInputFromUser();

    Meeting meeting = new Meeting(user, new TimeRange(start, end));
    meeting.save();
  }

  private static void addUser(String[] args) {
    if (args.length < 3) {
      System.out.println("Enter username and password for adding user...");
      return;
    }
    User user = new User(args[1], args[2]);
    user.save();
    System.out.println("Successfully added user");
  }

}
