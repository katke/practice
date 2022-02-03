package educative.codinginterviewpatterns.mergeintervals;

import shared.commontypes.Interval;
import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;

public class MutuallyExclusiveIntervals {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * logn)";
  String spaceComplexity = "O(n)";
  /*
  * Given a list of intervals, merge all the overlapping intervals to produce a list that has
  * only mutually exclusive intervals.
  * Intervals: [[1,4], [2,5], [7,9]]
    Output: [[1,5], [7,9]]
    Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
    one [1,5].
  * */
  List<Interval> merge(List<Interval> intervals) {
    if (intervals == null) throw new IllegalArgumentException("input cannot be null");
    else if (intervals.isEmpty() || intervals.size() == 1) return intervals;
    List<Interval> sortedIntervals = new ArrayList<>(intervals);
    sortedIntervals.sort((interval1, interval2) -> Integer.compare(interval1.start, interval2.start));
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
