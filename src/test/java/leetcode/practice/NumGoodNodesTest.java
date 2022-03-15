package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumGoodNodesTest {
    NumGoodNodes clazz = new NumGoodNodes();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(TreeNode input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          testCase1(),
          testCase2(),
          testCase3(),
          testCase4(),
          testCase5(),
          testCase6()
      );
    }

    private static Arguments testCase1() {
      // [3,1,4,3,null,1,5]
      var root = new TreeNode(3);
      root.left = new TreeNode(1);
      root.right = new TreeNode(4);
      root.left.left = new TreeNode(3);
      root.right.left = new TreeNode(1);
      root.right.right = new TreeNode(5);
      return arguments(root, 4);
    }

  private static Arguments testCase2() {
    // [3,3,null,4,2]
    var root = new TreeNode(3);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(2);
    return arguments(root, 3);
  }

  private static Arguments testCase3() {
    //  [1]
    var root = new TreeNode(1);
    return arguments(root, 1);
  }

  private static Arguments testCase4() {
    var root = new TreeNode(2);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(5);
    root.left.left.left.left = new TreeNode(1);
    return arguments(root, 3);
  }

  private static Arguments testCase5() {
    var root = new TreeNode(4);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(1);
    return arguments(root, 3);
  }

  private static Arguments testCase6() {
    var root = new TreeNode(4);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(4);
    return arguments(root, 4);
  }

  }
