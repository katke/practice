package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class JumpGame2 {
  String source = "https://leetcode.com/problems/jump-game-ii/";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_TIME_OPTIMIZATION;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
*/
// recursive method to try each intermediate scenario from start index to the last element jump index
  // keep track of the number of hops for each path, return the smallest
  Map<Integer, Integer> minJumpsToLast = new HashMap<>();

  int iterativeSolution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Deque<List<Integer>> queue = new ArrayDeque<>();
    int minJumps = Integer.MAX_VALUE;
    List<Integer> startingPath = new ArrayList<>();
    startingPath.add(0);
    queue.addLast(startingPath);
    while (!queue.isEmpty()) {
      var currentPath = queue.removeFirst();
      var mostRecentIndex = currentPath.get(currentPath.size() - 1);
      if (minJumpsToLast.containsKey(mostRecentIndex)) {
        minJumps = Math.min(minJumps, currentPath.size() + minJumpsToLast.get(mostRecentIndex));
      }
      var maxNextJump = nums[mostRecentIndex];
      for (int i = 1; i <= maxNextJump; i++) {
        var nextIndex = i + mostRecentIndex;
        if (nextIndex >= nums.length) continue;
        if (minJumpsToLast.containsKey(nextIndex)) {
          minJumps = Math.min(minJumps, currentPath.size() + minJumpsToLast.get(nextIndex));
        } else {
          if (nextIndex == nums.length - 1) {
            updateJumpsMemo(currentPath);
            minJumps = Math.min(minJumps, currentPath.size());
          } else {
            List<Integer> updatedList = new ArrayList<>(currentPath);
            updatedList.add(nextIndex);
            queue.addLast(updatedList);
          }
        }
      }
    }
    return minJumps;
  }

  void updateJumpsMemo(List<Integer> path) {
    int totalJumps = path.size();
    for (int i = 0; i < path.size(); i++) {
      int index = path.get(i);
      int jumpsFromEnd = totalJumps - i;
      if (minJumpsToLast.containsKey(index)) {
        minJumpsToLast.put(index, Math.min(minJumpsToLast.get(index), jumpsFromEnd));
      } else {
        minJumpsToLast.put(index, jumpsFromEnd);
      }
    }
  }

  int solution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return followPath(nums, 0, 0, 0, Integer.MAX_VALUE);
  }

  int followPath(int[] nums, int prevIndex, int index, int jumpsSoFar, int minJumps) {
    if (index == nums.length - 1) {
      return jumpsSoFar;
    }
    int minVal = minJumps;
    int nextMaxHop = nums[index];
    for (int i = 1; i <= nextMaxHop; i++) {
      if (index + i < nums.length) {
        minVal = Math.min(minVal, followPath(nums, index, index + i, jumpsSoFar + 1, minJumps));
      }
    }
    return minVal;
  }

}
