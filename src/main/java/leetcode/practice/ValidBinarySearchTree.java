package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidBinarySearchTree {
  String source = "https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/

  boolean solution(TreeNode root) {
    var arr = new ArrayList<Integer>();
    arr.remove((Integer) 0);
    int listSize = arr.size() - 1;
    arr.remove(listSize - 1);
    var map = new HashMap<Integer,Integer>();


    return isSubtreeValid(root, null, null);
  }

  boolean isSubtreeValid(TreeNode root, Integer max, Integer min) {
    if (root == null) return true;
    System.out.println("Min: " + min + ", max: " + max + ", " + root);
    if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
      return false;
    }
    return isSubtreeValid(root.left, root.val, min) && isSubtreeValid(root.right, max, root.val);
  }

}
