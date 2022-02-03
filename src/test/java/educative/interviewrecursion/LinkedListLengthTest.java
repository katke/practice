package educative.interviewrecursion;

import shared.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LinkedListLengthTest {
  LinkedListLength linkedListLength = new LinkedListLength();

  @ParameterizedTest
  @MethodSource("getInputs")
  void testSolution(ListNode head, int expected) {
    var actual = linkedListLength.lengthOfList(head);
    assertEquals(expected, actual);
  }


  private static Stream<Arguments> getInputs() {
    ListNode testCase1 = new ListNode(1);
    testCase1.next = new ListNode(1);
    testCase1.next.next = new ListNode(3);
    testCase1.next.next.next = new ListNode(1);
    testCase1.next.next.next.next = new ListNode(2);
    testCase1.next.next.next.next.next = new ListNode(1);

    ListNode singleNodeList = new ListNode(4);

    return Stream.of(
        arguments(testCase1, 6),
        arguments(null, 0),
        arguments(singleNodeList, 1)
    );
  }

}
