package educative.codinginterviewpatterns.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinimumDepthTest {
  MinimumDepth minimumDepth = new MinimumDepth();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(TreeNode root, int expected) {
    var actual = minimumDepth.solution(root);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(testCase1Tree(), 3),
        arguments(testCase2Tree(), 4),
        arguments(testCase3Tree(), 3)
    );
  }

  private static TreeNode testCase1Tree() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
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
    root.left.left.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return root;
  }
}
