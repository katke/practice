package leetcode.graph;

import shared.PracticeStatus;

import java.util.*;

public class DoesPathExist {
  String source = "https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3894/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(V + E) vertices/n + num of edges";
  String spaceComplexity = "O(V + E) vertices/n + num of edges";
  /*
  * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
  * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes
  * a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
  * and no vertex has an edge to itself.
  *
  * You want to determine if there is a valid path that exists from vertex source to vertex destination.
  * Given edges and the integers n, source, and destination, return true if there is a valid path from
  * source to destination, or false otherwise.
  *
    1 <= n <= 2 * 10^5
    0 <= edges.length <= 2 * 10^5
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.
  * */

  boolean validPathBFS(int n, int[][] edges, int source, int destination) {
    if (source == destination) return true;
    else if (edges == null || edges.length == 0 || n == 0) return false;
    Deque<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> adjMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjMap.put(i, new HashSet<>());
    }
    for (int i = 0; i < edges.length; i++) {
      var start = edges[i][0];
      var end = edges[i][1];
      adjMap.compute(start, (key, val) -> {
        val.add(end);
        return val;
      });
      adjMap.compute(end, (key, val) -> {
        val.add(start);
        return val;
      });
    }
    queue.addLast(source);
    while (!queue.isEmpty()) {
      var currentNode = queue.removeFirst();
      if (!visited.contains(currentNode)) {
        if (currentNode == destination) return true;
        visited.add(currentNode);
        var neighbors = adjMap.get(currentNode);
        for (Integer neighbor : neighbors) {
          queue.addLast(neighbor);
        }
      }
    }
    return false;
  }

  boolean validPathDFS(int n, int[][] edges, int source, int destination) {

  }
}
