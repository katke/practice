package leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.Node;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NextRightNodeTest {
  NextRightNode nextRightNode = new NextRightNode();

  @ParameterizedTest(name = "BFS test case {index}")
  @MethodSource("testCases")
  void testBfsSolution(NextRightNode.Node root, NextRightNode.Node expected) {
    assertTreeEquals(expected, nextRightNode.connectIterativeBfs(root));
  }

  @ParameterizedTest(name = "Recursive DFS test case {index}")
  @MethodSource("testCases")
  void testDfsSolution(NextRightNode.Node root, NextRightNode.Node expected) {
    assertTreeEquals(expected, nextRightNode.connectDfs(root));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        tree1()
    );
  }

  static Arguments tree1() {
    NextRightNode.Node root = new NextRightNode.Node(1);
    root.left = new NextRightNode.Node(2);
    root.right = new NextRightNode.Node(3);
    root.left.left = new NextRightNode.Node(4);
    root.left.right = new NextRightNode.Node(5);
    root.right.left = new NextRightNode.Node(6);
    root.right.right = new NextRightNode.Node(7);

    NextRightNode.Node expectedRoot = new NextRightNode.Node(1);
    expectedRoot.left = new NextRightNode.Node(2);
    expectedRoot.right = new NextRightNode.Node(3);
    expectedRoot.left.next = expectedRoot.right;

    expectedRoot.left.left = new NextRightNode.Node(4);
    expectedRoot.left.right = new NextRightNode.Node(5);
    expectedRoot.left.left.next = expectedRoot.left.right;

    expectedRoot.right.left = new NextRightNode.Node(6);
    expectedRoot.left.right.next = expectedRoot.right.left;

    expectedRoot.right.right = new NextRightNode.Node(7);
    expectedRoot.right.left.next = expectedRoot.right.right;

    return arguments(root, expectedRoot);
  }

  void assertTreeEquals(NextRightNode.Node expected, NextRightNode.Node actual) {
    Deque<NextRightNode.Node> expectedQueue = new ArrayDeque<>();
    Deque<NextRightNode.Node> actualQueue = new ArrayDeque<>();
    expectedQueue.addLast(expected);
    actualQueue.addLast(actual);
    try {
      while (!expectedQueue.isEmpty()) {
        assertEquals(expectedQueue.size(), actualQueue.size());
        NextRightNode.Node currentExpected = expectedQueue.removeFirst();
        System.out.println("currentExpected: " + currentExpected.val);
        NextRightNode.Node currentActual = actualQueue.removeFirst();
        System.out.println("currentActual: " + currentActual.val);
        assertTrue(currentActual.equals(currentExpected));

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
