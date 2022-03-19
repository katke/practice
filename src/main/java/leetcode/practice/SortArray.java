package leetcode.practice;

import shared.PracticeStatus;

import java.util.Arrays;

public class SortArray {
  String source = "https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(log(n) * n)";
  String spaceComplexity = "O(n)";

  // implement merge sort

  int[] solution(int[] nums) {
      if (nums == null || nums.length == 0) return new int[]{};
      return sortSubArrays(nums);
    }

    int[] sortSubArrays(int[] nums) {
      System.out.println("sortSubArrays input nums " + Arrays.toString(nums));
      if (nums.length <= 1){
        System.out.println("sortSubArrays returning nums! ");
        return nums;
      }
      int[] firstHalf = sortSubArrays(Arrays.copyOfRange(nums, 0, nums.length / 2));
      int[] secondHalf = sortSubArrays(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
      return merge(firstHalf, secondHalf);
    }

    int[] merge(int[] leftHalf, int[] rightHalf) {
      System.out.println("merge leftHalf " + Arrays.toString(leftHalf));
      System.out.println("merge rightHalf " + Arrays.toString(rightHalf));
      int[] mergedResult = new int[leftHalf.length + rightHalf.length];
      int left = 0, right = 0;
      while (right + left < leftHalf.length + rightHalf.length - 1) {
        if (leftHalf[left] < rightHalf[right]) {
          mergedResult[right + left] = leftHalf[left];
          if (left == leftHalf.length - 1) {
            while(right < rightHalf.length) {
              mergedResult[right + left + 1] = rightHalf[right];
              right++;
            }
          }
          left++;
        } else {
          mergedResult[right + left] = rightHalf[right];
          if (right == rightHalf.length - 1) {
            while(left < leftHalf.length) {
              mergedResult[right + left + 1] = leftHalf[left];
              left++;
            }
          }
          right++;
        }
      }
      return mergedResult;
    }
}
