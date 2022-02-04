package educative.codinginterviewpatterns.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TreeLevelSubarraysTest {
  TreeLevelSubarrays treeLevelSubarrays = new TreeLevelSubarrays();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(TreeNode root, List<List<Integer>> expected) {
    var actual = treeLevelSubarrays.solution(root);
    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2()
    );
  }

  private static Arguments testCase1() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    return arguments(root, List.of(List.of(12), List.of(7, 1), List.of(9, 10, 5)));
  }

  private static Arguments testCase2() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return arguments(root,
        List.of(
            List.of(1),
            List.of(2, 3),
            List.of(4, 5),
            List.of(6, 7)));
  }

}
