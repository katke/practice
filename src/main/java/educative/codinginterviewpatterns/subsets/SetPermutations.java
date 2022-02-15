package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.*;

public class SetPermutations {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/B8R83jyN3KY";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * n!)";
  String spaceComplexity = "O(n * n!)";
  /*
   * Given a set of distinct numbers, find all of its permutations. Permutation is defined as the
   * re-arranging of the elements of the set.
   * */

  List<List<Integer>> solution(int[] nums) {
    if (nums == null || nums.length == 0) return List.of();
    List<List<Integer>> result = new ArrayList<>();
    Deque<List<Integer>> queue = new ArrayDeque<>();
    queue.addLast(new ArrayList<>());
    for (int num : nums) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        List<Integer> currentPermutation = queue.removeFirst();
        for (int j = 0; j <= currentPermutation.size(); j++) {
          List<Integer> newPermutation = new ArrayList<>(currentPermutation);
          newPermutation.add(j, num);
          if (newPermutation.size() == nums.length) {
            result.add(newPermutation);
          } else {
            queue.addLast(newPermutation);
          }
        }
      }
    }
    return result;
  }

  List<List<Integer>> recursiveSolution(int[] nums) {
    if (nums == null || nums.length == 0) return List.of();
    List<List<Integer>> result = new ArrayList<>();
    addPermutations(nums, 0, result, new ArrayList<>());
    return result;
  }

  void addPermutations(int[] nums, int index, List<List<Integer>> result, List<Integer> currentPermutation) {
    if (index == nums.length) {
      result.add(currentPermutation);
      return;
    }
    int num = nums[index];
    for (int i = 0; i <= currentPermutation.size(); i++) {
      List<Integer> newPermutation = new ArrayList<>(currentPermutation);
      newPermutation.add(i, num);
      addPermutations(nums, index + 1, result, newPermutation);
    }
  }
}
