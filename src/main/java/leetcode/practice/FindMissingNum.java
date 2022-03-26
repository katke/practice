package leetcode.practice;

import shared.PracticeStatus;

import java.util.Arrays;

public class FindMissingNum {
  String source = "https://leetcode.com/problems/missing-number/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED; // but space could be optimized to O(1) by mutating input
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
that is missing from the array.

n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
All the numbers of nums are unique.
*/

  int solution(int[] nums) {
    if (nums == null) return 0;
    var copy = new Integer[nums.length];
    for (int val : nums) {
      if (val < nums.length) copy[val] = val;
    }
    System.out.println(Arrays.toString(copy));
    var prevVal = copy[0];
    for (int i = 0; i < copy.length; i++) {
      var val = copy[i];
      if (val == null) return i;
    }
    return nums.length;
  }
}
