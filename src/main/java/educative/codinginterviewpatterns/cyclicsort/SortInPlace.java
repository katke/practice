package educative.codinginterviewpatterns.cyclicsort;

import shared.PracticeStatus;

import java.util.Arrays;

public class SortInPlace {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";

  /*
  * We are given an array containing n objects. Each object, when created, was assigned a unique number
  * from the range 1 to n based on their creation sequence. This means that the object with sequence
  * number 3 was created just before the object with sequence number 4.
  * Write a function to sort the objects in-place on their creation sequence number in O(n) and
  * without using any extra space. For simplicity, let’s assume we are passed an integer array containing
  * only the sequence numbers, though each number is actually an object.
  * */

  void solution(int[] nums) {
    if (nums == null || nums.length == 0) return;
    int i = 0;
    while (i < nums.length) {
      int currentNumber = nums[i];
      if (i == currentNumber - 1) {
        i++;
        continue;
      }
      int correctIndex = currentNumber - 1;
      int swappedNumTmp = nums[correctIndex];
      nums[correctIndex] = currentNumber;
      nums[i] = swappedNumTmp;
    }
  }
}
