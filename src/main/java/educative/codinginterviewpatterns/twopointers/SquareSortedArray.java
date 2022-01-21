package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

import java.util.Arrays;

public class SquareSortedArray {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";
  /*
  Given a sorted array, create a new array containing squares of all
  the numbers of the input array in the sorted order.
   */

  int[] makeSquares(int[] arr) {
    if (arr == null || arr.length == 0) return new int[]{};
    int[] squares = new int[arr.length];
    int left = 0, right = arr.length - 1, sqIndex = arr.length - 1;
    int leftSq = 0, rightSq = 0;
    while (sqIndex >= 0) {
        leftSq = arr[left] * arr[left];
        rightSq = arr[right] * arr[right];
        if (rightSq > leftSq) {
          squares[sqIndex] = rightSq;
          right--;
        } else {
          squares[sqIndex] = leftSq;
          left++;
        }
      sqIndex -= 1;
    }
    return squares;
  }
}
