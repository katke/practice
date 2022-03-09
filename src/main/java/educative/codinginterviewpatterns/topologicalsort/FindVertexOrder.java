package educative.codinginterviewpatterns.topologicalsort;

import shared.PracticeStatus;

import java.util.*;

public class FindVertexOrder {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/m25rBmwLV00";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(V + E)";
  String spaceComplexity = "O(V + E)";

  /*
   * Given a directed graph, find the topological ordering of its vertices.
   * */
  List<Integer> solution(int vertices, int[][] edges) {
    if (edges == null || edges.length == 0 || vertices == 0) return List.of();
    Map<Integer, Set<Integer>> adjList = createAdjacencyMap(edges);
    Map<Integer, Integer> incomingEdgeCount = createEdgeCountMap(edges, vertices);
    System.out.println("adjList: " + adjList);
    System.out.println("incomingEdgeCount: " + incomingEdgeCount);
    Deque<Integer> queue = new ArrayDeque<>();
    for (Map.Entry<Integer, Integer> entry : incomingEdgeCount.entrySet()) {
      if (entry.getValue() == 0) queue.addLast(entry.getKey());
    }
    List<Integer> path = new ArrayList<>();
    // constraints say we can assume there will be a source and sink node
    while (!queue.isEmpty()) {
      var current = queue.removeFirst();
      path.add(current);
      System.out.println(path);
      var children = adjList.getOrDefault(current, new HashSet<>());
      for (int child : children) {
        System.out.println("child: " + child);
        // we just processed the parent of this child, so we can decrement the number of incoming edges for this child
        incomingEdgeCount.compute(child, (key, val) -> val == null ? 0 : val - 1);
        System.out.println("incomingEdgeCount: " + incomingEdgeCount);
        // if the incoming edge count is zero, then it's essentially a source node now, add to queue
        if (incomingEdgeCount.get(child) == 0) queue.addLast(child);
      }
    }
    // if path is > vertices then there's a cycle somewhere; we should be able to hit each node once from source to sink
    return path.size() == vertices ? path : List.of();
  }

  Map<Integer, Set<Integer>> createAdjacencyMap(int[][] edges) {
    Map<Integer, Set<Integer>> adjMap = new HashMap<>();
    for (int[] edge : edges) {
      var current = adjMap.getOrDefault(edge[0], new HashSet<>());
      current.add(edge[1]);
      adjMap.put(edge[0], current);
    }
    return adjMap;
  }

  Map<Integer, Integer> createEdgeCountMap(int[][] edges, int numNodes) {
    Map<Integer, Integer> incomingEdgeCount = new HashMap<>();
    for (int i = 0; i < numNodes; i++) {
      incomingEdgeCount.put(i, 0);
    }
    for (int[] edge : edges) {
      var current = incomingEdgeCount.get(edge[1]);
      incomingEdgeCount.put(edge[1], current + 1);
    }
    return incomingEdgeCount;
  }
}
