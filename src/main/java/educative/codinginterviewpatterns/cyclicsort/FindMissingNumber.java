package educative.codinginterviewpatterns.cyclicsort;

import shared.PracticeStatus;

import java.util.Arrays;

public class FindMissingNumber {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";
  /*
  * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
  * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
  * */
  int solution(int[] nums) {
    if (nums == null || nums.length == 0) throw new IllegalArgumentException("");
    int i = 0, missingNum = nums.length;
    while (i < nums.length) {
      if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
        // nums[i] < nums.length: skip the highest num since we don't have space for it in sorted array anyway
        // nums[i] != nums[nums[i]]: check if current num corresponds to its index, as it should
        // since it's 0...n array, so int 3 should be at index 3, etc
        // if not, swap it with what is currently in the index it should be in
        swap(nums, i, nums[i]);
      } else {
        i++;
      }
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i) missingNum = i;
    }

    return missingNum;
  }

  private static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " for " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    System.out.println("Arr: " + Arrays.toString(arr));
  }

  int expensiveSpaceSolution(int[] nums) {
    int missingNum = -1;
    boolean[] orderingArr = new boolean[nums.length + 1];
    for (int i : nums) {
      orderingArr[i] = true;
    }
    for (int i = 0; i < orderingArr.length; i++) {
      if (!orderingArr[i]) missingNum = i;
    }
    return missingNum;
  }
}
