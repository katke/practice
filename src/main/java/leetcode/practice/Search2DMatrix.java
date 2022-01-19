package leetcode.practice;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.Arrays;

// Runtime complexity: O(m * n logn)
// Space complexity: n logn
public class Search2DMatrix implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
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
  // Space complexity: O(1)
  boolean mostOptimizedSolution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    int midpoint = numRows / 2;
    if (matrix[midpoint][0] > target) {

    }
    return false;
  }


  boolean binarySearch(int[] arr, int target) {
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

}
