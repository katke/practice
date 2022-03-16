package leetcode.practice;

import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class JumpGame3 {
  String source = "https://leetcode.com/problems/jump-game-iii/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
  * Given an array of non-negative integers arr, you are initially positioned at
  * start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i],
  * check if you can reach to any index with value 0.
  * Notice that you can not jump outside of the array at any time.
  * */

  // recursive function:
  // take in the next index to look at
  // if next index val == 0, return true
  // return function call: recurse(-) || recurse(+)
  // if next index >= length of arr, skip that side, if both do, return false

  boolean solution(int[] arr, int start) {
    if (arr == null || start >= arr.length || start < 0) return false;
    return canReachZero(arr, start, new HashSet<>());
  }

  boolean canReachZero(int[] arr, int start, Set<Integer> visitedIndexes) {
    if (arr[start] == 0) return true;
    else if (visitedIndexes.contains(start)) return false; // we're in a loop
    visitedIndexes.add(start);
    int nextIndexSum = start + arr[start];
    int nextIndexDiff = start - arr[start];
    boolean nextIndexSumIsValid = nextIndexSum < arr.length && nextIndexSum >= 0;
    boolean nextIndexDiffIsValid = nextIndexDiff < arr.length && nextIndexDiff >= 0;
    if (nextIndexSumIsValid && nextIndexDiffIsValid) {
      return canReachZero(arr, nextIndexSum, visitedIndexes) || canReachZero(arr, nextIndexDiff, visitedIndexes);
    } else if (nextIndexSumIsValid) {
      return canReachZero(arr, nextIndexSum, visitedIndexes);
    } else if (nextIndexDiffIsValid) {
      return canReachZero(arr, nextIndexDiff, visitedIndexes);
    } else {
      return false;
    }
  }

  boolean iterativeSolution(int[] arr, int start) {
    if (arr == null || start >= arr.length || start < 0) return false;
    Set<Integer> visitedIndexes = new HashSet<>();
    Deque<Integer> stack = new ArrayDeque<>();
    stack.addFirst(start);
    while (!stack.isEmpty()) {
      int currentIndex = stack.removeFirst();
      if (arr[currentIndex] == 0) return true;
      if (!visitedIndexes.contains(currentIndex)) {
        visitedIndexes.add(currentIndex);
        int nextIndexSum = currentIndex + arr[currentIndex];
        int nextIndexDiff = currentIndex - arr[currentIndex];
        boolean nextIndexSumIsValid = nextIndexSum < arr.length && nextIndexSum >= 0;
        boolean nextIndexDiffIsValid = nextIndexDiff < arr.length && nextIndexDiff >= 0;
        if (nextIndexSumIsValid && nextIndexDiffIsValid) {
          stack.addFirst(nextIndexSum);
          stack.addFirst(nextIndexDiff);
        } else if (nextIndexSumIsValid) {
          stack.addFirst(nextIndexSum);
        } else if (nextIndexDiffIsValid) {
          stack.addFirst(nextIndexDiff);
        }
      }
    }
    return false;
  }

}
