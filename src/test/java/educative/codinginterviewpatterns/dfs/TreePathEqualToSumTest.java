package educative.codinginterviewpatterns.dfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TreePathEqualToSumTest {
  TreePathEqualToSum treePathEqualToSum = new TreePathEqualToSum();

  @ParameterizedTest(name = "Recursive solution: {index}")
  @MethodSource("testCases")
  void testRecursiveSolution(TreeNode root, int sum, boolean expected) {
    var actual = treePathEqualToSum.solution(root, sum);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "Iterative solution: {index}")
  @MethodSource("testCases")
  void testIterativeSolution(TreeNode root, int sum, boolean expected) {
    var actual = treePathEqualToSum.iterativeSolution(root, sum);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1Tree(),
        testCase2Tree(),
        testCase3Tree(),
        testCase4Tree()
    );
  }

  private static Arguments testCase1Tree() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    return arguments(root, 21, true);
  }

  private static Arguments testCase2Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return arguments(root, 15, false);
  }

  private static Arguments testCase3Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return arguments(root, 11, true);
  }

  private static Arguments testCase4Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return arguments(root, 14, false);
  }
}
