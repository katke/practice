package leetcode.practice;

import shared.PracticeStatus;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  String source = "https://leetcode.com/problems/longest-consecutive-sequence/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)"; // hashset.contains(x) is O(1) time complexity
  String spaceComplexity = "O(n)";
  /*
  *
  * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
  * You must write an algorithm that runs in O(n) time.
  * [100,4,200,1,3,2] => 4
  * */

  int longestConsecutive(int[] nums) {
    if (nums == null) return 0;
    else if (nums.length < 2) return nums.length;
    Set<Integer> values = new HashSet<>();
    for (int val : nums) {
      values.add(val);
    }
    int maxCount = 0;
    for (int val : nums) {
      boolean isStartOfStreak = !values.contains(val - 1);
      if (isStartOfStreak) {
        int currentStreak = 1, currentNum = val;
        while (values.contains(currentNum + 1)) {
          currentStreak++;
          currentNum += 1;
        }
        maxCount = Math.max(currentStreak, maxCount);
      }
    }
    return maxCount;
  }

}
