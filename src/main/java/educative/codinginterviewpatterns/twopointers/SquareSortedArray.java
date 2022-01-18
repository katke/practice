package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

public class SquareSortedArray {
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/R1ppNG3nV9R";
  /*
  Given a sorted array, create a new array containing squares of all
  the numbers of the input array in the sorted order.
   */

  int[] makeSquares(int[] arr) {
    if (arr == null || arr.length == 0) return new int[]{};
    int[] squares = new int[arr.length];
    int left = 0, right = arr.length - 1, sqIndex = arr.length - 1;
    int leftSq = 0, rightSq = 0;
    while (left != right) {
      leftSq = arr[left] * arr[left];
      rightSq = arr[right] * arr[right];
      if (rightSq > leftSq) {
        squares[sqIndex] = rightSq;
        squares[sqIndex - 1] = leftSq;
      } else {
        squares[sqIndex] = leftSq;
        squares[sqIndex - 1] = rightSq;
      }
      sqIndex -= 2;
      left++;
      right--;
    }
    return squares;
  }
}
