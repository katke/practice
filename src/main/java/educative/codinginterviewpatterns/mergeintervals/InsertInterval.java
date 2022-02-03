package educative.codinginterviewpatterns.mergeintervals;

import shared.commontypes.Interval;
import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3jKlyNMJPEM";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
  * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct
  * position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
  * */

  List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.isEmpty()) return List.of(newInterval);
    List<Interval> sortedIntervals = new ArrayList<>(intervals);
    sortedIntervals.add(newInterval);
    sortedIntervals.sort(Comparator.comparingInt(interval -> interval.start));
    var currentMergedInterval = sortedIntervals.get(0);
    var mergedIntervals = new ArrayList<Interval>();
    mergedIntervals.add(currentMergedInterval);
    for (Interval interval : sortedIntervals) {
      if (interval.start > currentMergedInterval.end) {
        currentMergedInterval = new Interval(interval.start, interval.end);
        mergedIntervals.add(currentMergedInterval);
      } else if (interval.end > currentMergedInterval.end) {
        currentMergedInterval.end = interval.end;
      }
    }
    return mergedIntervals;
  }

}
