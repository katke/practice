package educative.codinginterviewpatterns.fastslowpointers;

import shared.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindStartOfCycleTest {
  FindStartOfCycle findStartOfCycle = new FindStartOfCycle();

  @ParameterizedTest(name = "Fast/Slow Pointer Test Case {index}")
  @MethodSource("testCases")
  void testSolution(ListNode inputHead, int expected) {
    var actual = findStartOfCycle.findCycleStart(inputHead);
    assertEquals(expected, actual.val);
  }

  @ParameterizedTest(name = "Alternate Solution Test Case {index}")
  @MethodSource("testCases")
  void testAlternateSolution(ListNode inputHead, ListNode expected) {
    var actual = findStartOfCycle.alternateSolution(inputHead);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2(),
        testCase3(),
        testCase4(),
        educativeTestCase1()
    );
  }

  private static Arguments testCase1() {
    ListNode linkedListHead = new ListNode(1);
    linkedListHead.next = new ListNode(2);
    linkedListHead.next.next = new ListNode(3);
    linkedListHead.next.next.next = new ListNode(4);
    linkedListHead.next.next.next.next = new ListNode(5);
    linkedListHead.next.next.next.next.next = new ListNode(6);
    linkedListHead.next.next.next.next.next.next = linkedListHead.next.next.next;
    return arguments(linkedListHead, 4);
  }

  private static Arguments testCase2() {
    ListNode linkedListHead = new ListNode(1);
    linkedListHead.next = new ListNode(2);
    linkedListHead.next.next = new ListNode(3);
    linkedListHead.next.next.next = new ListNode(4);
    linkedListHead.next.next.next.next = new ListNode(5);
    linkedListHead.next.next.next.next.next = new ListNode(6);
    linkedListHead.next.next.next.next.next.next = linkedListHead;
    return arguments(linkedListHead, 1);
  }

  private static Arguments testCase3() {
    ListNode linkedListHead = new ListNode(1);
    linkedListHead.next = new ListNode(2);
    linkedListHead.next.next = new ListNode(3);
    linkedListHead.next.next.next = new ListNode(4);
    linkedListHead.next.next.next = linkedListHead.next.next;
    return arguments(linkedListHead, 3);
  }

  private static Arguments testCase4() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;
    node2.next = node1;
    return arguments(node1, 1);
  }

  private static Arguments educativeTestCase1() {
    ListNode head = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(3);
    var node4 = new ListNode(4);
    var node5 = new ListNode(5);
    var node6 = new ListNode(6);

    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node3;

    return arguments(head, 3);
  }
}
