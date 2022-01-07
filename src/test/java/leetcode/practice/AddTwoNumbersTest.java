package leetcode.practice;

import leetcode.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AddTwoNumbersTest {

  AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

  @ParameterizedTest
  @MethodSource("getTestCases")
  void testSolution(String expecting, List<ListNode> input, List<Integer> expected) {
    System.out.println(expecting);
    var actual = addTwoNumbers.solution(input.get(0), input.get(1));
    int i = 0;
    int linkedListLength = 0;
    while (actual != null) {
      assertEquals(expected.get(i), actual.val);
      actual = actual.next;
      i++;
      linkedListLength++;
    }
    assertEquals(expected.size(), linkedListLength);
  }

  static Stream<Arguments> getTestCases() {
    // 342 + 465 = 807
    var tc1Node1 = new ListNode(2);
    var tc1Node2 = new ListNode(4);
    var tc1Node3 = new ListNode(3);
    tc1Node1.next = tc1Node2;
    tc1Node2.next = tc1Node3;

    var tc1Node4 = new ListNode(5);
    var tc1Node5 = new ListNode(6);
    var tc1Node6 = new ListNode(4);
    tc1Node4.next = tc1Node5;
    tc1Node5.next = tc1Node6;

    // 17 + 6 = 23
    var tc2Node1 = new ListNode(7);
    var tc2Node2 = new ListNode(1);
    tc2Node1.next = tc2Node2;

    var tc2Node3 = new ListNode(6);

    // 87 + 21 = 108
    var tc3Node1 = new ListNode(7);
    var tc3Node2 = new ListNode(8);
    tc3Node1.next = tc3Node2;

    var tc3Node3 = new ListNode(1);
    var tc3Node4 = new ListNode(2);
    tc3Node3.next = tc3Node4;

    // 1 + 9
    var tc4Node1 = new ListNode(1);
    var tc4Node2 = new ListNode(9);

    return Stream.of(
        arguments("Expected: 7 -> 0 -> 8", List.of(tc1Node1, tc1Node4), List.of(7, 0, 8)),
        arguments("Expected: 3 -> 2", List.of(tc2Node1, tc2Node3), List.of(3, 2)),
        arguments("Expected: 8 -> 0 -> 1", List.of(tc3Node1, tc3Node3), List.of(8, 0, 1)),
        arguments("Exepcted: 0 -> 1", List.of(tc4Node1, tc4Node2), List.of(0, 1))
    );
  }

}
