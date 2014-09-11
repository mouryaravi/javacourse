/**
 * Created by ravi on 10/09/14.
 */
public class TimeRange {
  private String start;
  private String end;

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public TimeRange(String start, String end) {
    this.start = start;
    this.end = end;
  }

}
