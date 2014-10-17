import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by ravi on 18/09/14.
 */
public class ScheduleDate extends Date {
  private Date date;

  public static ScheduleDate ScheduleDateFromString(String dateStr) {
    ScheduleDate scheduleDate = new ScheduleDate();
    DateFormat df = DateFormat.getDateTimeInstance();
    try {
      scheduleDate.date = df.parse(dateStr);
    } catch (ParseException e) {
      throw new RuntimeException("Invalid Date time: " + dateStr);
    }
    return scheduleDate;
  }
}
