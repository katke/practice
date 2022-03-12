package educative.codinginterviewpatterns.topologicalsort;

import shared.PracticeStatus;

import java.util.*;

public class AllTaskSchedulingOrder {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/q2YmVjQMMr3";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
  * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks
  * which need to be completed before it can be scheduled. Given the number of tasks and a list of
  * prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites.
  * */
  List<List<Integer>> solution(int tasks, int[][] prerequisites) {
    if (tasks == 0 || prerequisites == null) return List.of(List.of());
    List<List<Integer>> result = new ArrayList<>();
    Deque<List<Integer>> pathQueue = new ArrayDeque<>();
    Map<Integer, Integer> incomingEdges = new HashMap<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    // initialize supporting data structures
    for (int i = 0; i < tasks; i++) {
      incomingEdges.put(i, 0);
      adjList.put(i, new ArrayList<>());
    }
    // fill in supporting data structures
    for (int[] taskOrder : prerequisites) {
      int sourceVertex = taskOrder[0];
      int sinkVertex = taskOrder[1];
      incomingEdges.put(sinkVertex, incomingEdges.get(sinkVertex) + 1);
      var sourceChildren = adjList.get(sourceVertex);
      sourceChildren.add(sinkVertex);
      adjList.put(sourceVertex, sourceChildren);
    }
    // find all our source nodes (i.e. nodes with no prereqs/incoming edges, which means they will be our starting point(s)
    for (var entry : incomingEdges.entrySet()) {
      if (entry.getValue() == 0) {
        var pathStart = new ArrayList<Integer>();
        pathStart.add(entry.getKey());
        pathQueue.addLast(pathStart);
      }
    }
    while (!pathQueue.isEmpty()) {
      var current = pathQueue.removeFirst();
      checkPath(incomingEdges, adjList, tasks, current, result);
    }
    return result;
  }

  void checkPath(Map<Integer, Integer> incomingEdges, Map<Integer, List<Integer>> adjList, int tasks, List<Integer> currentPath, List<List<Integer>> result) {
    if (currentPath.size() == tasks) {
      result.add(currentPath);
      return;
    }
    var lastVertex = currentPath.get(currentPath.size() - 1);
    var children = adjList.get(lastVertex);
    for (int child : children) {
      incomingEdges.compute(child, (key, val) -> val - 1);
      if (incomingEdges.get(child) == 0) {
        List<Integer> copiedPath = new ArrayList<>(currentPath);
        copiedPath.add(child);
        checkPath(incomingEdges, adjList, tasks, copiedPath, result);
      }
    }
  }

}
