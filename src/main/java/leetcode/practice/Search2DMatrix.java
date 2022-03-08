package leetcode.practice;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.Arrays;

// Runtime complexity: O(m * n logn)
// Space complexity: n logn
public class Search2DMatrix implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.FAIL_SPACE_OPTIMIZATION;
  String source = "https://leetcode.com/problems/search-a-2d-matrix/";

  // Time Complexity: O(n * m), where n = num rows, and m = num of columns
  // Space complexity: O(1)
  boolean bruteForceSolution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        if (matrix[i][j] == target) {
          return true;
        }
      }
    }
    return false;
  }

  // Time Complexity: O(n + m), where n = num of rows, and m = num of columns
  // Space complexity: O(1)
  boolean medianSolution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    for (int[] row : matrix) {
      if (row[row.length - 1] >= target) {
        for (int val : row) {
          if (val == target) return true;
        }
      }
    }
    return false;
  }

  // Time complexity: O(n * log(m)), n = num of rows, m = num of columns/items in row
  // Space complexity: O(m)
  boolean optimizedSolution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int[] relevantRow = new int[matrix[0].length];
    for (int[] row : matrix) {
      if (row[row.length - 1] >= target) {
        relevantRow = row;
        break;
      }
    }
    if (relevantRow.length == 0) return false;
    else {
      return binarySearch(relevantRow, target);
    }
  }

  // Time complexity: O(log(n*m)), binary search both col and rows
  // Space complexity: O(logm + logn)
  boolean optimizedSolution2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    var relevantRow = matrixBinarySearch(matrix, target);
    return binarySearch(relevantRow, target);
  }

  private int[] matrixBinarySearch(int[][] matrix, int target) {
    if (matrix.length == 2) {
      if (target > matrix[0][matrix[0].length - 1]) return matrix[1];
      else return matrix[0];
    } else if (matrix.length == 1) return matrix[0];
    var midpoint = matrix.length / 2;
    var midpointArr = matrix[midpoint];
    if (target == midpointArr[midpointArr.length - 1]) {
      return new int[]{midpointArr[midpointArr.length - 1]};
    } else if (target > midpointArr[midpointArr.length - 1]) {
        return matrixBinarySearch(Arrays.copyOfRange(matrix, midpoint + 1, matrix.length), target);
    } else {
      return matrixBinarySearch(Arrays.copyOfRange(matrix, 0, midpoint + 1), target);
    }
  }

  private boolean binarySearch(int[] arr, int target) {
    if (arr.length == 1) {
      return arr[0] == target;
    }
    var midpoint = arr.length / 2;
    var leftSide = Arrays.copyOfRange(arr, 0, midpoint);
    var rightSide = Arrays.copyOfRange(arr, midpoint, arr.length);
    if (arr[midpoint] > target) {
      return binarySearch(leftSide, target);
    } else {
      return binarySearch(rightSide, target);
    }
  }

  // Time complexity: O(log(n*m))
  // Space complexity: O(1)
  // TODO under construction, close but still buggy
  boolean mostOptimizedSolution(int[][] matrix, int target) {
//    System.out.println(target);
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    if (matrix.length == 1) return binarySearch(matrix[0], target);
    int rows = matrix.length, cols = matrix[0].length;
    if (target > matrix[rows - 1][cols - 1] || target < matrix[0][0]) { // is in range?
      return false;
    }
    int left = 0, right = rows * cols - 1;
    while (left < right) {
      int midpointIndex = (right + left) / 2;
      System.out.println("midpointIndex: " + midpointIndex);
      int mpRowIndex = midpointIndex / cols;
      System.out.println("mpRowIndex: " + mpRowIndex);
      int mpColumnIndex = midpointIndex % cols;
      System.out.println("mpColumnIndex: " + mpColumnIndex);
      int mpVal = matrix[mpRowIndex][mpColumnIndex];
      System.out.println("mpVal: " + mpVal);
      if (target == mpVal) {
        return true;
      } else if (target > mpVal) {
        left = midpointIndex + 1;
        System.out.println("left: " + left);
      } else {
        right = midpointIndex - 1;
        System.out.println("right: " + right);
      }
    }
    return false;
  }


}
