package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.Interval;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervals {
  String source = "https://leetcode.com/problems/merge-intervals/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n^2 + n)";
  String spaceComplexity = "O(n)";
  /*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
of the non-overlapping intervals that cover all the intervals in the input.
*/

  int[][] solution(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return new int[0][0];
    else if (intervals.length == 1) return intervals;
    var mergedResult = new ArrayList<int[]>();
    var sortedIntervals = new ArrayList<Interval>();
    for (int[] interval : intervals) {
      sortedIntervals.add(new Interval(interval[0], interval[1]));
    }
    sortedIntervals.sort(Comparator.comparingInt(interval -> interval.start));
    var inProgressMerge = new int[]{sortedIntervals.get(0).start, sortedIntervals.get(0).end};
    for (int i = 1; i < sortedIntervals.size(); i++) {
      var currInterval = sortedIntervals.get(i);
      if (currInterval.start <= inProgressMerge[1]) {
        inProgressMerge[1] = Math.max(inProgressMerge[1], currInterval.end);
      } else {
        mergedResult.add(inProgressMerge);
        inProgressMerge = new int[]{currInterval.start, currInterval.end};
      }
      if (sortedIntervals.size() - 1 == i) mergedResult.add(inProgressMerge);
    }
    var finalResult = new int[mergedResult.size()][2];
    for (int i = 0; i < mergedResult.size(); i++) {
      finalResult[i] = mergedResult.get(i);
    }
    return finalResult;
  }
}
