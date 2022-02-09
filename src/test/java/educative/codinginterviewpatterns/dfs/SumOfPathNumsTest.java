package educative.codinginterviewpatterns.dfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SumOfPathNumsTest {
  SumOfPathNums sumOfPathNums = new SumOfPathNums();

  @ParameterizedTest(name = "Recursive solution {index}")
  @MethodSource("testCases")
  void testRecursiveSolution(TreeNode root, int expected) {
    var actual = sumOfPathNums.solution(root);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1Tree(),
        testCase2Tree(),
        testCase3Tree()
    );
  }

  private static Arguments testCase1Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return arguments(root, 2603);
  }

  private static Arguments testCase2Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    return arguments(root, 332);
  }

  private static Arguments testCase3Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    return arguments(root, 1245);
  }

}
