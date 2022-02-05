package educative.codinginterviewpatterns.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ZigzagTraversalTest {
  ZigzagTraversal zigzagTraversal = new ZigzagTraversal();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(TreeNode root, List<List<Integer>> expected) {
    var actual = zigzagTraversal.solution(root);
    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(testCase1Tree(), List.of(
            List.of(12),
            List.of(1, 7),
            List.of(9, 10, 5),
            List.of(17, 20))),
        arguments(testCase2Tree(), List.of(
            List.of(1),
            List.of(3, 2),
            List.of(4, 5),
            List.of(7, 6))),
        arguments(testCase3Tree(), List.of(
            List.of(1),
            List.of(3,2),
            List.of(4,5,6,7)
        ))
    );
  }

  private static TreeNode testCase1Tree() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    return root;
  }

  private static TreeNode testCase2Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return root;
  }

  private static TreeNode testCase3Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return root;
  }
}
