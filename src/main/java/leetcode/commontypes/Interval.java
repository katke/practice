package leetcode.commontypes;

public class Interval {
  public int start;
  public int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return String.format(
        "Interval start: %s, end: %s",
        this.start,
        this.end);
  }
}
