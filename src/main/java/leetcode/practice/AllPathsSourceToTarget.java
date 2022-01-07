package leetcode.practice;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllPathsSourceToTarget implements PracticeProblem {
  String source = "https://leetcode.com/problems/all-paths-from-source-to-target/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;

  public List<List<Integer>> solution(int[][] graph) {
    var allPaths = new ArrayList<List<Integer>>();
    findPaths(allPaths, new ArrayList<>(), 0, graph);
    return allPaths;
  }

  private void findPaths(List<List<Integer>> allPaths, List<Integer> currentPath, int currentNode, final int[][] graph) {
    currentPath.add(currentNode);
    var target = graph.length - 1;
    if (currentNode == target) {
      allPaths.add(currentPath);
      return;
    }
    var adjList = graph[currentNode];
    if (adjList.length == 0) return;
    for (int nextNode : adjList) {
      findPaths(allPaths, new ArrayList<>(currentPath), nextNode, graph);
    }
  }

}
