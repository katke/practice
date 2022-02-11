package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.*;

public class DistinctSubsets {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O()";
  String spaceComplexity = "O()";
  /*
  * Given a set of numbers that might contain duplicates, find all of its distinct subsets
  * */
  List<List<Integer>> solution(int[] nums) {
    if (nums == null) throw new IllegalArgumentException();
    if (nums.length == 0) return List.of();
    List<List<Integer>> uniqueSubsets = new ArrayList<>();
    uniqueSubsets.add(new ArrayList<>());
    for (int num : nums) {
      int subsetSize = uniqueSubsets.size();
      for (int i = 0; i < subsetSize; i++) {
        List<Integer> newSubset = new ArrayList<>(uniqueSubsets.get(i));
        newSubset.add(num);
        if (!uniqueSubsets.contains(newSubset)) {
          uniqueSubsets.add(newSubset);
        }
      }
    }
    return uniqueSubsets;
  }

}
