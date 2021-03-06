package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class CourseSchedule {
  String source = "https://leetcode.com/problems/course-schedule/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O(V + E)";
  String spaceComplexity = "";

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
*/

  boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses < 1 || prerequisites == null || prerequisites.length == 0) return true;
    Map<Integer, Set<Integer>> courses = buildAdjMap(numCourses, prerequisites);
    System.out.println(courses);
    Map<Integer, Integer> incomingEdges = buildIncomingEdges(numCourses, prerequisites);
    System.out.println(incomingEdges);
    Deque<Integer> sourcesQueue = new ArrayDeque<>();
    for (var entry : incomingEdges.entrySet()) {
      if (entry.getValue() == 0) sourcesQueue.addLast(entry.getKey());
    }
    if (sourcesQueue.isEmpty()) return false;
    List<Integer> sortedPath = new ArrayList<>();
    while (!sourcesQueue.isEmpty()) {
      System.out.println("queue: " + sourcesQueue);
      int current = sourcesQueue.removeFirst();
      sortedPath.add(current);
      System.out.println("sortedPath: " + sortedPath);
      var children = courses.get(current);
      for (int child : children) {
        System.out.println("child: " + child);
        incomingEdges.put(child, incomingEdges.get(child) - 1);
        System.out.println(incomingEdges);
        if (incomingEdges.get(child) == 0) sourcesQueue.addLast(child);
      }
    }
    return sortedPath.size() == numCourses;
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

  //  boolean canFinish(int numCourses, int[][] prerequisites) {
//    if (numCourses < 1 || prerequisites == null || prerequisites.length == 0) return true;
//    Map<Integer, Set<Integer>> courses = buildAdjMap(numCourses, prerequisites);
//    for (int course : courses.keySet()) {
//      if (!isCyclic(course, courses, new HashSet<>())) {
//        return true;
//      }
//    }
//    return false;
//  }

  protected boolean isCyclic(Integer currCourse, Map<Integer, Set<Integer>> courseDict, Set<Integer> visited) {

    if (visited.contains(currCourse)) {
      // come across a previously visited node, i.e. detect the cycle
      return true;
    }

    // no following courses, no loop.
    if (!courseDict.containsKey(currCourse))
      return false;

    // before backtracking, mark the node in the path
    visited.add(currCourse);

    // backtracking
    boolean ret = false;
    for (Integer nextCourse : courseDict.get(currCourse)) {
      ret = this.isCyclic(nextCourse, courseDict, visited);
      if (ret)
        break;
    }
    // after backtracking, remove the node from the path
    visited.remove(currCourse);
    return ret;
  }

}
