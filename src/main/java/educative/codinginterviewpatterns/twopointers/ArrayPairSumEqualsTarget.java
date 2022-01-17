package educative.codinginterviewpatterns.twopointers;

public class ArrayPairSumEqualsTarget {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP";

  /*
  * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
  * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
  * */

  int[] search(int[] arr, int targetSum) {
    int[] result = new int[] {-1, -1};
    long currentSum;
    int right = arr.length - 1, left = 0;
    while (left < arr.length && right >= 0) {
      currentSum = arr[right] + arr[left];
      if (currentSum == targetSum) {
        result[0] = left;
        result[1] = right;
        break;
      } else if (currentSum < targetSum) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }

}
