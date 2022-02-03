package educative.codinginterviewpatterns.fastslowpointers;

import shared.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SingleLinkedListHasCycleTest {
  SingleLinkedListHasCycle singleLinkedListHasCycle = new SingleLinkedListHasCycle();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(ListNode linkedListHead, boolean expected) {
    var actual = singleLinkedListHasCycle.hasCycle(linkedListHead);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    ListNode noCycleHead = new ListNode(1);
    noCycleHead.next = new ListNode(2);
    noCycleHead.next.next = new ListNode(3);
    noCycleHead.next.next.next = new ListNode(4);
    noCycleHead.next.next.next.next = new ListNode(5);
    noCycleHead.next.next.next.next.next = new ListNode(6);

    ListNode hasCycleHead = new ListNode(1);
    hasCycleHead.next = new ListNode(2);
    hasCycleHead.next.next = new ListNode(3);
    hasCycleHead.next.next.next = new ListNode(4);
    hasCycleHead.next.next.next.next = new ListNode(5);
    hasCycleHead.next.next.next.next.next = new ListNode(6);
    hasCycleHead.next.next.next.next.next.next = hasCycleHead.next.next;

    ListNode fullCycleHead = new ListNode(1);
    fullCycleHead.next = new ListNode(2);
    fullCycleHead.next.next = new ListNode(3);
    fullCycleHead.next.next.next = fullCycleHead;

    return Stream.of(
        arguments(noCycleHead, false),
        arguments(hasCycleHead, true),
        arguments(fullCycleHead, true)
    );
  }
}
