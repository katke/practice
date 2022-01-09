package educative.interviewrecursion;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class LinkedListLength {

    PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
    String source = "https://www.educative.io/courses/recursion-for-coding-interviews-in-java/mE5Zm3P2pzE";
    String description = "Recursively find the length of a linked list";
    String timeComplexity = "O(n), where n = length of list";
    String spaceComplexity = "O(n), where n = length of list";

  public int lengthOfList(ListNode head) {
    if (head != null) {
      return lengthOfList(head.next) + 1;
    } else {
      return 0;
    }
  }

}
