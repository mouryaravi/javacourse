/**
 * Created by ravi on 10/09/14.
 */
public class Meeting {
  private User user;
  private TimeRange timeRange;
  private static final String MEETINGS_FILE = "./meetings.txt";

  public Meeting(User user, TimeRange timeRange) {
    this.user = user;
    this.timeRange = timeRange;
  }


  public void save() {
    FileWriter fileWriter = new FileWriter(MEETINGS_FILE);
    fileWriter.addLine(user.getUsername() + ":" + timeRange.getStart() + ":" + timeRange.getEnd());
  }

}
