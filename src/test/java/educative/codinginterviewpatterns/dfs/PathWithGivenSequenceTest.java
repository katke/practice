package educative.codinginterviewpatterns.dfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PathWithGivenSequenceTest {
  PathWithGivenSequence pathWithGivenSequence = new PathWithGivenSequence();

  @ParameterizedTest
  @MethodSource("testCases")
  void testRecursiveSolution(TreeNode root, int[] sequence, boolean expected) {
    var actual = pathWithGivenSequence.solution(root,sequence);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2(),
        testCase3()
    );
  }

  private static Arguments testCase1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return arguments(root, new int[]{1,2,4,6}, true);
  }

  private static TreeNode tree2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    return root;
  }

  private static Arguments testCase2() {
    return arguments(tree2(), new int[]{1,0,1}, true);
  }

  private static Arguments testCase3() {
    return arguments(tree2(), new int[]{1,0,5}, false);
  }

}
