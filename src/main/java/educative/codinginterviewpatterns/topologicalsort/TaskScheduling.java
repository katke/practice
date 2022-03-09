package educative.codinginterviewpatterns.topologicalsort;

import shared.PracticeStatus;

import java.util.*;

public class TaskScheduling {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/gxJrM9goEMr";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
  * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which
  * need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite
  * pairs, find out if it is possible to schedule all the tasks.
  * */

  boolean solution(int tasks, int[][] prerequisites) {
    if (tasks == 0 || prerequisites == null || prerequisites.length == 0) return false;
    Map<Integer, Set<Integer>> adjList = new HashMap<>(); // TODO handle self referencing nodes
    Map<Integer, Integer> incomingEdges = new HashMap<>();
    for (int[] prereq : prerequisites) {
      int parent = prereq[0];
      int child = prereq[1];
      var currentChildren = adjList.getOrDefault(parent, new HashSet<>());
      currentChildren.add(child);
      adjList.put(parent, currentChildren);
      incomingEdges.put(child, incomingEdges.getOrDefault(child, 0) + 1);
    }
    Deque<Integer> sourceQueue = new ArrayDeque<>();
    for (int i = 0; i < tasks; i++) {
      if (!incomingEdges.containsKey(i)) sourceQueue.addLast(i);
    }
    if (sourceQueue.isEmpty()) return false;
    Set<Integer> visited = new HashSet<>();
    while (!sourceQueue.isEmpty()) {
      int current = sourceQueue.removeFirst();
      if (visited.contains(current)) return false;
      visited.add(current);
      for (int child : adjList.getOrDefault(current, new HashSet<>())) {
        if (child == current) return false;
        incomingEdges.put(child, incomingEdges.getOrDefault(child, 1) - 1);
        if (incomingEdges.get(child) == 0) {
          sourceQueue.addLast(child);
        }
      }
    }
    return true;
  }
}
