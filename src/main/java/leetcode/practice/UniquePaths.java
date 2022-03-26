package leetcode.practice;

import shared.PracticeStatus;

import java.lang.reflect.Array;
import java.util.*;

public class UniquePaths {
  String source = "https://leetcode.com/problems/unique-paths/";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_TIME_OPTIMIZATION; // Needs to use dynamic programming to pass
  String timeComplexity = "O((N*M) + (N + M + E))"; // E = edges
  String spaceComplexity = "O(n*m)";
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
1 <= m, n <= 100
*/

  int solution(int m, int n) {
    if (m < 1 || n < 1) return 0;
    else if (m == 1 || n == 1) return 1;
    var end = arrToKey(new int[]{m,n});
    var adjList = buildAdjList(m,n);
    int paths = 0;
    var queue = new ArrayDeque<String>();
    var pathStart = arrToKey(new int[]{1,1});
    queue.addLast(pathStart);
    while (!queue.isEmpty()) {
      var lastPos = queue.removeFirst();
      var neighbors = adjList.get(lastPos);
      for (var neighbor : neighbors) {
        if (neighbor.contentEquals(end)) {
          paths++;
        } else {
          queue.addLast(neighbor);
        }
      }
    }
    return paths;
  }

  Map<String, List<String>> buildAdjList(int m, int n) {
    var adj = new HashMap<String, List<String>>();
    for (int mi = 1; mi <= m; mi++) {
      for (int ni = 1; ni <= n; ni++) {
        var node = arrToKey(new int[]{mi,ni});
        var neighbors = new ArrayList<String>();
        if (ni < n) {
          var moveRight = arrToKey(new int[]{mi,ni + 1});
          neighbors.add(moveRight);
        }
        if (mi < m) {
          var moveDown = arrToKey(new int[]{mi + 1, ni});
          neighbors.add(moveDown);
        }
        adj.put(node, neighbors);
      }
    }
    return adj;
  }

  String arrToKey(int[] arr) {
    return String.format("%s-%s", arr[0], arr[1]);
  }
}
