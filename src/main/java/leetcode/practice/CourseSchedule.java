package leetcode.practice;

import shared.PracticeStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
  String source = "https://leetcode.com/problems/course-schedule/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
*/

  boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses < 1 || prerequisites == null || prerequisites.length == 0) return true;
    Map<Integer, Set<Integer>> courses = new HashMap<>();
    for (int[] prereq : prerequisites) {
      int courseId = prereq[0];
      int prereqId = prereq[1];
      courses.compute(courseId, (key, val) -> {
        if (val == null) {
          var newPrereqSet = new HashSet<Integer>();
          newPrereqSet.add(prereqId);
          return newPrereqSet;
        } else {
          val.add(prereqId);
          return val;
        }
      });
    }
    return prereqsAreNotCyclic(new HashSet<>(), courses, prerequisites[0][0], numCourses, 0);
  }

  private boolean prereqsAreNotCyclic(Set<Integer> visited, final Map<Integer, Set<Integer>> courses, int courseId, int maxNumOfCourses, int coursesSoFar) {
    if (coursesSoFar > maxNumOfCourses) {
      return false;
    } else if (!courses.containsKey(courseId)) {
      return true;
    } else {
      visited.add(courseId);
      for (int prereq : courses.get(courseId)) {
        if (!visited.contains(prereq)) {
          return prereqsAreNotCyclic(new HashSet<>(visited), courses, prereq, maxNumOfCourses, coursesSoFar + 1);
        }
      }
      return false;
    }
  }
}
