package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

public class RemoveDuplicates {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA";
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(1)";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;

  /*
  * Given an array of sorted numbers, remove all duplicates from it.
  * You should not use any extra space; after removing the duplicates in-place return the length of the subarray
  * that has no duplicate in it.
   * */

  int remove(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    int left = 0, right = 1, length = 1;
    while (right < arr.length) {
      if (arr[right] != arr[left]) {
        length += 1;
      }
      right++;
      left++;
    }
    return length;
  }

}
