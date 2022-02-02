package educative.codinginterviewpatterns.cyclicsort;

import shared.PracticeStatus;

public class FindDuplicate {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3wEkKy6Pr9A";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";
  /*
  * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
  * The array has only one duplicate but it can be repeated multiple times. Find that
  * duplicate number without using any extra space. You are, however, allowed to modify
  * the input array.
  * */

  int solution(int[] nums) {
    if (nums == null || nums.length < 2) throw new IllegalArgumentException("Invalid input array");
    var i = 0;
    while (i < nums.length) {
      var currentVal = nums[i];
      if (currentVal == i + 1) {
        i++;
        continue;
      }
      var swapValue = nums[currentVal - 1];
      if (swapValue == currentVal) return swapValue;
      nums[i] = swapValue;
      nums[currentVal - 1] = currentVal;
    }
    return nums.length - 1;
  }
}
