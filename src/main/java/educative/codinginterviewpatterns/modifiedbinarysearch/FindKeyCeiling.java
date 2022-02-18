package educative.codinginterviewpatterns.modifiedbinarysearch;

import shared.PracticeStatus;

public class FindKeyCeiling {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/qA5wW7R8ox7";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(log(n))";
  String spaceComplexity = "Iterative: O(1), recursive: O(log(n))";
  /*
  * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
  * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
  * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
  * */
  int solution(int[] arr, int key) {
    if (arr == null || arr.length == 0) return -1;
    return binarySearch(arr, 0, arr.length - 1, key);
  }

  int binarySearch(int[] arr, int startIndex, int endIndex, int key) {
    if (endIndex - startIndex == 0) {
      if (arr[startIndex] >= key) {
        return startIndex;
      } else {
        return arr.length > startIndex + 1
            ? startIndex + 1
            : -1;
      }
    }
    int midpointIdx = ((endIndex - startIndex) / 2) + startIndex;
    if (arr[midpointIdx] == key) {
      return midpointIdx;
    }
    if (arr[midpointIdx] > key) {
      // go left
      return binarySearch(arr, startIndex, midpointIdx, key);
    } else {
      // go right
      return binarySearch(arr, midpointIdx + 1, endIndex, key);
    }
  }

  int iterativeSolution(int[] arr, int key) {
    if (arr == null || arr.length == 0) return -1;
    int startIndex = 0, endIndex = arr.length - 1;
    while (startIndex < endIndex) {
      int midpointIdx = ((endIndex - startIndex) / 2) + startIndex;
      int midpoint = arr[midpointIdx];
      if (midpoint == key) {
        return midpointIdx;
      }
      if (midpoint > key) {
         endIndex = midpointIdx;
      } else {
        startIndex = midpointIdx + 1;
      }
    }
      if (arr[startIndex] >= key) {
        return startIndex;
      } else {
        return arr.length > startIndex + 1
            ? startIndex + 1
            : -1;
      }
  }
}
