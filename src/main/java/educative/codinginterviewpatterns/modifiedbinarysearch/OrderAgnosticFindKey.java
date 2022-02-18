package educative.codinginterviewpatterns.modifiedbinarysearch;

import shared.PracticeStatus;

import java.util.Arrays;

public class OrderAgnosticFindKey {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/R8LzZQlj8lO";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(log(n)) for iterative, more like O(n * log(n)) for recursive for copying arr";
  String spaceComplexity = "O(1) for iterative, O(log(n)) for recursive";

  /*
  * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
  * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
  * You should assume that the array can have duplicates.
  * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
  * */

  int solution(int[] arr, int key) {
    if (arr == null || arr.length == 0) return -1;
    if (arr.length == 1) return arr[0] == key ? 0 : -1;
    System.out.println("Key: " + key + ", arr: " + Arrays.toString(arr));
    boolean isAscending = true;
    if (arr[0] > arr[arr.length - 1]) isAscending = false;
    return binarySearch(arr, key, 0, arr.length - 1, isAscending);
  }

  int binarySearch(int[] arr, int key, int startIndex, int endIndex, boolean isAscending) {
    if (arr.length == 1) {
       return arr[0] == key ? startIndex : -1;
    }
    int midpoint = arr.length / 2;
    if (arr[midpoint] == key) {
      return startIndex + midpoint;
    }

    if (arr[midpoint] > key) {
      if (isAscending) {
        int[] left = Arrays.copyOfRange(arr, 0, midpoint);
        return binarySearch(left, key, startIndex, endIndex - midpoint - 1, isAscending);
      } else {
        int[] right = Arrays.copyOfRange(arr, midpoint, arr.length);
        return binarySearch(right, key, startIndex + midpoint, endIndex, isAscending);
      }
    } else {
      if (isAscending) {
        int[] right = Arrays.copyOfRange(arr, midpoint, arr.length);
        return binarySearch(right, key, startIndex + midpoint, endIndex, isAscending);
      } else {
        int[] left = Arrays.copyOfRange(arr, 0, midpoint);
        return binarySearch(left, key, startIndex, endIndex - midpoint - 1, isAscending);
      }
    }
  }

  int iterativeSolution(int[] arr, int key) {
    if (arr == null || arr.length == 0) return -1;
    if (arr.length == 1) return arr[0] == key ? 0 : -1;
    System.out.println("Key: " + key + ", arr: " + Arrays.toString(arr));
    boolean isAscending = true;
    if (arr[0] > arr[arr.length - 1]) isAscending = false;
    int start = 0, end = arr.length - 1;
    while (start < end) {
      int midpoint = (end / 2) + (start / 2);
      if (arr[midpoint] == key) {
        return midpoint;
      }
      if (key > arr[midpoint]) {
        if (isAscending) start = start + midpoint;
        else end = end - midpoint - 1;
      } else {
        if (isAscending) end = end - midpoint - 1;
        else start = start + midpoint;
      }
    }
    return arr[start] == key ? start : -1;
  }
}
