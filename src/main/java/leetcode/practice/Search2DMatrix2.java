package leetcode.practice;

import shared.PracticeStatus;

import java.util.Arrays;

public class Search2DMatrix2 {
  String source = "https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n + m) optimized, O(m * log(n)) for binary search";
  String spaceComplexity = "O(1) optimized, O(n^2) binary search (would be less if I just used index nums)";
  /*
  Write an efficient algorithm that searches for a value target in an m x n integer matrix.
  This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
-10^9 <= target <= 10^9
*/

  boolean solution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    else if (target < matrix[0][0] || target > matrix[matrix.length -1][matrix[0].length - 1]) return false;
    int column = 0, row = matrix.length - 1;
    while (column <= matrix[0].length - 1 && row >= 0) {
      int pivot = matrix[row][column];
      if (target > pivot) {
        column++;
      } else if (target < pivot) {
        row--;
      } else {
        return true;
      }
    }
    return false;
  }

  boolean binarySearchSolution(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    else if (target < matrix[0][0] || target > matrix[matrix.length -1][matrix[0].length - 1]) return false;
    for (int[] row : matrix) {
      boolean result = splitRows(row, target);
      if (result) return true;
    }
    return false;
  }

  boolean splitRows(int[] row, int target) {
//    System.out.println("splitRows() " + Arrays.toString(row));
    if (row.length == 1) {
      return row[0] == target;
    } else if (row[0] > target || row[row.length - 1] < target) {
      return false;
    }
    int midpoint = row.length / 2;
    int midpointVal = row[midpoint];
    if (midpointVal == target) return true;
    else if (target > midpointVal) {
      int[] right = Arrays.copyOfRange(row, midpoint, row.length);
      return splitRows(right, target);
    } else {
      int[] left = Arrays.copyOfRange(row, 0, midpoint);
      return splitRows(left, target);
    }
  }
}
