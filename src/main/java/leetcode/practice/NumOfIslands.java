package leetcode.practice;

import lombok.val;
import shared.PracticeStatus;

import java.util.Arrays;

public class NumOfIslands {
  String source = "";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number
of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

  int solution(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    var islandCount = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        islandCount += markIsland(r, c, grid);
      }
    }
    for (int r = 0; r < grid.length; r++) {
      System.out.println(Arrays.toString(grid[r]));
    }
    return islandCount;
  }

  int markIsland(int row, int col, char[][] grid) {
    if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 ||
    grid[row][col] != '1') return 0;
    // we are officially on an an unexplored island now
    grid[row][col] = 'x';
    // check right
    markIsland(row, col + 1, grid);
    // check left
    markIsland(row, col - 1, grid);
    // check up
    markIsland(row - 1, col, grid);
    // check down
    markIsland(row + 1, col, grid);
    return 1;
  }
}
