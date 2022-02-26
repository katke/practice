package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class CourseSchedule2 {
  String source = "https://leetcode.com/problems/course-schedule-ii/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";

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
    if (prerequisites == null || prerequisites.length == 0) return new int[]{};
    Map<Integer, List<Integer>> courses = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    for (int[] pair : prerequisites) {
      int courseId = pair[0];
      int prereq = pair[1];
      List<Integer> currentPrereqs = courses.getOrDefault(courseId, new ArrayList<>());
      currentPrereqs.add(prereq);
      courses.put(courseId, currentPrereqs);
    }
    System.out.println(courses);
    findCourseProgression(new ArrayList<>(), result, prerequisites[0][0], courses, new ArrayList<>(), numCourses);
    return result.isEmpty()
      ? new int[]{}
      : result.get(0).stream().mapToInt(Integer::intValue).toArray();
  }

  void findCourseProgression(List<Integer> courseOrder, List<List<Integer>> results, int courseId,
                             Map<Integer, List<Integer>> courses, List<Integer> alreadySeen, int numCourses) {
    System.out.println("-".repeat(15));
    // if next progression is null (end of prereq chain) or equal to numCourses + 1 (checked all possible courses)
    // add to result (along with any unaccounted for classes) and return
    // if the node is present in alreadyVisited (is a cycle), don't add to result and return
    // else loop through the prereqs and start new findCourseProgression call for each
    // add to alreadyVisited list
    System.out.println("findCourseProgression(): courseId " + courseId);
    System.out.println("alreadySeen: " + alreadySeen);
    if (!courses.containsKey(courseId)) {
      courseOrder.add(0, courseId);
      if (courseOrder.size() < numCourses) {
        for (int i = 0; i < numCourses; i++) {
          if (!courseOrder.contains(i)) {
            courseOrder.add(i);
          }
        }
        System.out.println("courseOrder: " + courseOrder);
        results.add(courseOrder);
      }
    } else if (alreadySeen.contains(courseId)) {
      // found a cycle
      System.out.println("cycle—courseOrder: " + courseOrder);
      return;
    } else {
      alreadySeen.add(courseId);
      System.out.println("courseOrder: " + courseOrder);
      for (Integer prereq : courses.get(courseId)) {
        findCourseProgression(
            new ArrayList<>(courseOrder),
            results, prereq, courses, alreadySeen, numCourses);
      }
    }
  }
}
