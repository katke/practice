package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class NumConnectedComponents {
  String source = "https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(V + E)";
  String spaceComplexity = "O(V + E)";
  /*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.
*/

  int solution(int n, int[][] edges) {
    if (edges == null || edges.length == 0) return n;
    int count = 0;
    var adj = buildAdjList(n, edges);
    var visited = new HashSet<Integer>();
    var queue = new ArrayDeque<Integer>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        queue.addLast(i);
        count++;
      }
      while (!queue.isEmpty()) {
        var current = queue.removeFirst();
        visited.add(current);
        for (var neighbor : adj.get(current)) {
          if (!visited.contains(neighbor)) {
            queue.addLast(neighbor);
          }
        }
      }
    }
    return count;
  }

  Map<Integer, Set<Integer>> buildAdjList(int n, int[][] edges) {
    var adj = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      var n1List = adj.get(edge[0]);
      n1List.add(edge[1]);
      adj.put(edge[0], n1List);
      var n2List = adj.get(edge[1]);
      n2List.add(edge[0]);
      adj.put(edge[1], n2List);
    }
    return adj;
  }
}
