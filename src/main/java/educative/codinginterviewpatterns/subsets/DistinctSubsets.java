package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.*;

public class DistinctSubsets {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * 2^n)";
  String spaceComplexity = "O(n * 2^n)";
  /*
  * Given a set of numbers that might contain duplicates, find all of its distinct subsets
  * */
  List<List<Integer>> solution(int[] nums) {
    if (nums == null) throw new IllegalArgumentException();
    if (nums.length == 0) return List.of();
    Arrays.sort(nums);
    List<List<Integer>> uniqueSubsets = new ArrayList<>();
    uniqueSubsets.add(new ArrayList<>());
    for (int numsIndex = 0; numsIndex < nums.length; numsIndex++) {
      int num = nums[numsIndex];
      int subsetSize = uniqueSubsets.size();
      int subsetStart = 0;
      if (numsIndex > 0 && nums[numsIndex - 1] == num) {
        subsetStart = numsIndex;
      }
      for (int subsetsIndex = subsetStart; subsetsIndex < subsetSize; subsetsIndex++) {
        List<Integer> newSubset = new ArrayList<>(uniqueSubsets.get(subsetsIndex));
        newSubset.add(num);
        uniqueSubsets.add(newSubset);
      }
    }
    return uniqueSubsets;
  }

}
