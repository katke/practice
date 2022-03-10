package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class CourseSchedule2 {
  String source = "https://leetcode.com/problems/course-schedule-ii/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(V + E)";
  String spaceComplexity = "O(V + E)";

  /*
  * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
  * You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take
  * course b first if you want to take course a.

  * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
  * Return the ordering of courses you should take to finish all courses. If there are many valid
  * answers, return any of them. If it is impossible to finish all courses, return an empty array.

  Input: numCourses = 2, prerequisites = [[1,0]]
  Output: [0,1]
  * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
  * course 0. So the correct course order is [0,1].
  *
  * 0: [n,n,2],
  * 1: [0,n,2],
  * 2: [0,1,n]
  * */

  int[] solution(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null) return new int[]{};
    Map<Integer, List<Integer>> courses = new HashMap<>();
    Map<Integer, Integer> incomingEdgeCount = new HashMap<>();
    Deque<Integer> sourceQueue = new ArrayDeque<>();
    int[] result = new int[numCourses];
    int coursesScheduled = 0;
    for (int i = 0; i < numCourses; i++) {
      incomingEdgeCount.put(i, 0);
      courses.put(i, new ArrayList<>());
    }
    for (int[] pair : prerequisites) {
      int course = pair[0];
      int prereq = pair[1];
      List<Integer> currentPrereqs = courses.get(prereq);
      currentPrereqs.add(course);
      courses.put(prereq, currentPrereqs);
      incomingEdgeCount.put(course, incomingEdgeCount.get(course) + 1);
    }
    for (var entry : incomingEdgeCount.entrySet()) {
      // source nodes here are the courses that have no prerequisites, i.e. no incoming edges
      if (entry.getValue() == 0) sourceQueue.addLast(entry.getKey());
    }
    if (sourceQueue.isEmpty()) return new int[]{}; // there's a circular dependency somewhere since there's no source nodes
    while (!sourceQueue.isEmpty()) {
      int current = sourceQueue.removeFirst();
      result[coursesScheduled] = current;
      coursesScheduled++;
      var children = courses.get(current);
      for (int child : children) {
        incomingEdgeCount.compute(child, (key, val) -> val == null ? 0 : val - 1);
        if (incomingEdgeCount.get(child) == 0) sourceQueue.addLast(child);
      }
    }
    return coursesScheduled == numCourses ? result : new int[]{};
  }
}
