package educative.codinginterviewpatterns.inplacereversal;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class ReverseSubList {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  /*
  * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
  * */

  ListNode solution(ListNode head, int p, int q) {
    if (head == null) throw new IllegalArgumentException("LinkedList head cannot be null");
    ListNode current = head, previous = null, next = head.next, pNode = null, qNode = null, pointsToQ = null;

    boolean inSublist = false;
    while (current != null) {
      if (current.val == p) {
        pNode = current;
        pointsToQ = previous;
        inSublist = true;
      } else if (current.val == q) {
        pointsToQ.next = current;
        pNode.next = current.next;
        inSublist = false;
      }
      previous = current;
      if (inSublist) {
        next = current.next;
        current.next = previous;
        current = next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

}
