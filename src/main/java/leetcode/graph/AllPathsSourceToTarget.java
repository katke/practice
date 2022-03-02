package leetcode.graph;

import shared.PracticeStatus;

import java.util.*;

public class AllPathsSourceToTarget {
  String source = "https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3853/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(2^V * V)";
  String spaceComplexity = "O(2^V * V)";

  /*
  * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from
  * node 0 to node n - 1 and return them in any order.
  *
  * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there
  * is a directed edge from node i to node graph[i][j]).
  *
    n == graph.length
    2 <= n <= 15
    0 <= graph[i][j] < n
    graph[i][j] != i (i.e., there will be no self-loops).
    All the elements of graph[i] are unique.
    The input graph is guaranteed to be a DAG.
  * */

  List<List<Integer>> allPathsSourceTargetBfs(int[][] graph) {
    if (graph == null || graph.length == 0 || graph[0].length == 0) return List.of();
    List<List<Integer>> allPathsResult = new ArrayList<>();
    int startNode = 0;
    int destinationNode = graph.length - 1;
    Deque<List<Integer>> pathQueue = new ArrayDeque<>();
    List<Integer> initialPath = new ArrayList<>();
    initialPath.add(startNode);
    pathQueue.addLast(initialPath);
    while (!pathQueue.isEmpty()) {
      List<Integer> currentPath = pathQueue.removeFirst();
      int lastNode = currentPath.get(currentPath.size() - 1);
      for (int neighbor : graph[lastNode]) {
        List<Integer> updatedPath = new ArrayList<>(currentPath);
        updatedPath.add(neighbor);
        pathQueue.addLast(updatedPath);
        if (neighbor == destinationNode) {
          allPathsResult.add(updatedPath);
        }
      }
    }
    return allPathsResult;
  }
}
