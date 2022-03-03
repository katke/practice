package leetcode.graph;

import shared.PracticeStatus;

import java.util.*;

public class ClearPath {
  String source = "https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3896/";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_IMPLEMENTATION;

  /*
   * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
   * If there is no clear path, return -1.
   *
   * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right
   * cell (i.e., (n - 1, n - 1)) such that:
   *   All the visited cells of the path are 0.
   *   All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they
   * share an edge or a corner).
   *
   * The length of a clear path is the number of visited cells of this path.
   * [[0,0,0],[1,1,0],[1,1,0]] => 4
   * [0,0,0]
   * [1,1,0]
   * [1,1,0]
   * */

  int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length == 0) return -1;
    int n = grid.length - 1;
    if (grid[0][0] == 1 || grid[n][n] == 1) return -1;
    int count = 0;
    var adjMap = adjList(grid);
    System.out.println(adjMap);
    Deque<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    queue.addLast(0);
    while (!queue.isEmpty()) {
      var current = queue.getFirst();

    }
//        int[] current = queue.getFirst(); // just add i val to queue?
//        int i = current[0], j = current[1];
//        visited.add(i);
//      for (int k = j; k < grid.length; k++) {
//        if (grid[i][j] == 0) {
//          count++;
//          queue.addLast(new int[]{i,j});
//          visited.add(k);
//          if (i == n && k == n) {
//            return count;
//          }
//        }
//      }
//
//    }
//    for (int i = 0; i < grid.length; i++) { for (int j = 0; j < grid[i].length; j++) {}
//
//    }

    return -1;
  }

  Map<Integer, Set<Integer>> adjList(int[][] graph) {
    int n = graph.length - 1;
    var map = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {
        if (graph[i][j] == 0) {
          var iSet = map.getOrDefault(i, new HashSet<>());
          iSet.add(j);
          if (j > 0) {
            iSet.add(j - 1);
          } else if (j < n) {
            iSet.add(j + 1);
          }
          map.put(i, iSet);
        }
      }
    }
    return map;
  }
}
