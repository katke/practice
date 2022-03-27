package common;

import leetcode.graph.NextRightNode;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomAsserts {

  // Only if order doesn't matter
  public void assertListEquals(List<?> expected, List<?> actual) {
    assertEquals(expected.size(), actual.size());
    for (Object expectedValue : expected) {
      System.out.println("expected: " + expectedValue);
      assertTrue(actual.contains(expectedValue));
    }
  }

  public void assertBinaryTreeEquals(TreeNode expected, TreeNode actual) {
    Deque<TreeNode> expectedQueue = new ArrayDeque<>();
    Deque<TreeNode> actualQueue = new ArrayDeque<>();
    expectedQueue.addLast(expected);
    actualQueue.addLast(actual);
    try {
      while (!expectedQueue.isEmpty()) {
        assertEquals(expectedQueue.size(), actualQueue.size());
        TreeNode currentExpected = expectedQueue.removeFirst();
        System.out.println("currentExpected: " + currentExpected.val);
        TreeNode currentActual = actualQueue.removeFirst();
        System.out.println("currentActual: " + currentActual.val);
        assertEquals(currentExpected.val, currentActual.val);

        if (currentExpected.right != null) {
          expectedQueue.addLast(currentExpected.right);
          actualQueue.addLast(currentActual.right);
        }
        if (currentExpected.left != null) {
          expectedQueue.addLast(currentExpected.left);
          actualQueue.addLast(currentActual.left);
        }
      }
    } catch (NullPointerException nullPointerException) {
      System.out.println("Some node is not where it's supposed to be in the actual queue, needs investigation");
      throw nullPointerException;
    }
    assertTrue(actualQueue.isEmpty());
  }
}
