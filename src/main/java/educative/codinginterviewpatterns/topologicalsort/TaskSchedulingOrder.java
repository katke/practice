package educative.codinginterviewpatterns.topologicalsort;

import shared.PracticeStatus;

import java.util.*;

public class TaskSchedulingOrder {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/BnnArPGKolJ";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(V+E)";
  String spaceComplexity = "O(V+E)";
/*
* There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to
* be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write
* a method to find the ordering of tasks we should pick to finish all tasks.
* */

  List<Integer> solution(int tasks, int[][] prerequisites) {
    if (tasks == 0 || prerequisites == null || prerequisites.length == 0) return List.of();
    Map<Integer, Set<Integer>> adjList = buildAdjMap(tasks, prerequisites);
    Map<Integer, Integer> incomingEdgeCount = buildIncomingEdges(tasks, prerequisites);
    Deque<Integer> sourceQueue = new ArrayDeque<>();
    List<Integer> taskOrder = new ArrayList<>();
    System.out.println("incomingEdgeCount: " + incomingEdgeCount);
    System.out.println("adjList: " + adjList);
    for (var entry : incomingEdgeCount.entrySet()) {
      if (entry.getValue() == 0) sourceQueue.addLast(entry.getKey());
    }
    while (!sourceQueue.isEmpty()) {
      int current = sourceQueue.removeFirst();
      taskOrder.add(current);
      var children = adjList.get(current);
      for (int child : children) {
        incomingEdgeCount.compute(child, (key, val) -> val == null ? 0 : val - 1);
        if (incomingEdgeCount.get(child) == 0) {
          sourceQueue.addLast(child);
        }
      }
    }
    System.out.println(taskOrder);
    return taskOrder.size() == tasks
        ? taskOrder
        : List.of();
  }


  private Map<Integer, Set<Integer>> buildAdjMap(int numCourses, int[][] prereqs) {
    Map<Integer, Set<Integer>> courses = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      courses.put(i, new HashSet<>());
    }
    for (int[] prereq : prereqs) {
      int courseId = prereq[0];
      int prereqId = prereq[1];
      courses.get(courseId).add(prereqId);
    }
    return courses;
  }

  private Map<Integer, Integer> buildIncomingEdges(int numCourses, int[][] prereqs) {
    Map<Integer, Integer> courses = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      courses.put(i, 0);
    }
    for (int[] prereq : prereqs) {
      int prereqId = prereq[1];
      courses.put(prereqId, courses.get(prereqId) + 1);
    }
    return courses;
  }

}
