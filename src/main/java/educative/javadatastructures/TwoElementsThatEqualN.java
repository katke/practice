package educative.javadatastructures;

import shared.PracticeStatus;

import java.util.Arrays;

public class TwoElementsThatEqualN {
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String source = "https://www.educative.io/courses/data-structures-coding-interviews-java/xVl0WZ09nY9";
  String description = "Given an array and a number \"n\", find two numbers from the array that sums up to \"n\"." +
      "Return the original array in case a pair is not found.";
  String timeComplexity = "Brute force: O(n^2)";
  String spaceComplexity;

  int[] findSumOptimized(int[] arr, int n) {
    if (arr == null) return new int[]{};
    else if (arr.length < 2) return arr;
    var arrCopy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arrCopy);
    var additionPair = new int[2];
    var foundPair = false;

    var leftIndex = 0;
    var rightIndex = arrCopy.length - 1;
    var left = arrCopy[leftIndex];
    var right = arrCopy[rightIndex];
    while (leftIndex < rightIndex && !foundPair) {
      if (left + right < n) {
        leftIndex++;
      } else if (right + left > n) {
        rightIndex--;
      } else {
        additionPair[0] = left;
        additionPair[1] = right;
        foundPair = true;
      }
      left = arrCopy[leftIndex];
      right = arrCopy[rightIndex];
    }

    return foundPair ? additionPair : arr;
  }

  int[] findSumBruteForce(int[] arr, int n) {
    if (arr == null) return new int[]{};
    else if (arr.length < 2) return arr;

    var additionPair = new int[2];
    var foundPair = false;

    var firstNumIndex = 0;
    while (firstNumIndex < arr.length - 1 && !foundPair) {
      var secondNumIndex = firstNumIndex + 1;
      var firstNum = arr[firstNumIndex];
      System.out.println("firstNum: " + firstNum);
      while (secondNumIndex < arr.length && !foundPair) {
        var secondNum = arr[secondNumIndex];
        System.out.println("SecondNum: " + secondNum);
        if (firstNum + secondNum == n) {
          additionPair[0] = firstNum;
          additionPair[1] = secondNum;
          foundPair = true;
          System.out.println("Found pair");
        }
        secondNumIndex++;
      }
      firstNumIndex++;
    }

    return foundPair ? additionPair : arr;
  }

}
