package educative.codinginterviewpatterns.dfs;

import shared.PracticeStatus;
import shared.commontypes.NodeSumTuple;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllPathsThatEqualSum {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/B815A0y2Ajn";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * log(n))";
  /*
  * n for traversing all nodes, log(n) for copying each current path list into new list. We know each
  * path can have a max of log(n) nodes since the max depth of a balanced binary tree is log(n) num of nodes
  * */
  String spaceComplexity = "O(n * log(n))";

  /*
  * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the
  * sum of all the node values of each path equals ‘S’.
  * */

  List<List<Integer>> solution(TreeNode root, int sum) {
    if (root == null) return List.of();
    List<List<Integer>> paths = new ArrayList<>();
    checkPaths(root, new ArrayList<>(), paths, sum);
    return paths;
  }

  void checkPaths(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths, int remainingSum) {
    currentPath.add(currentNode.val);
    if (currentNode.left == null && currentNode.right == null) {
      if ((remainingSum - currentNode.val) == 0) allPaths.add(currentPath);
      return;
    }
    if (currentNode.left != null) {
      checkPaths(currentNode.left, new ArrayList<>(currentPath), allPaths, remainingSum - currentNode.val);
    }
    if (currentNode.right != null) {
      checkPaths(currentNode.right, new ArrayList<>(currentPath), allPaths, remainingSum - currentNode.val);
    }
  }

  List<List<Integer>> iterativeSolution(TreeNode root, int sum) {
    if (root == null) return List.of();
    List<List<Integer>> paths = new ArrayList<>();
    Deque<NodePathTuple> nodes = new ArrayDeque<>();
    nodes.addLast(new NodePathTuple(root, 0, new ArrayList<>()));
    while (!nodes.isEmpty()) {
      NodePathTuple currentNode = nodes.removeLast();
      if (currentNode.node.left == null && currentNode.node.right == null) {
        if (currentNode.currentSum == sum) paths.add(currentNode.currentPath);
        continue;
      }
      if (currentNode.node.right != null) {
        nodes.addLast(new NodePathTuple(currentNode.node.right, currentNode.currentSum, new ArrayList<>(currentNode.currentPath)));
      }
      if (currentNode.node.left != null) {
        nodes.addLast(new NodePathTuple(currentNode.node.left, currentNode.currentSum, new ArrayList<>(currentNode.currentPath)));
      }
    }
    return paths;
  }

  static class NodePathTuple extends NodeSumTuple {
    List<Integer> currentPath;
    NodePathTuple(TreeNode node, int currentSum, List<Integer> currentPath) {
      super(node, currentSum);
      this.currentPath = currentPath;
      this.currentPath.add(node.val);
    }
  }
}
