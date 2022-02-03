package leetcode.practice;

import shared.commontypes.ListNode;
import shared.PracticeProblem;
import shared.PracticeStatus;
import static shared.PracticeStatus.ACCEPTED;

// 2: https://leetcode.com/problems/add-two-numbers/
// status: accepted
public class AddTwoNumbers implements PracticeProblem {
  public PracticeStatus problemStatus= ACCEPTED;
  public ListNode solution(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return new ListNode(0);
    } else if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    var currentSum = 0;
    var carryOver = 0;
    ListNode rootNode = new ListNode();
    ListNode currentSumNode = rootNode;
    var isFirstPass = true;
    // Traverse LLs one node at a time
    // Add each digit, with the sum appearing in the new list
    // if sum > 9, carry over 1 to next node
    var l1Current = l1;
    var l2Current = l2;
    while (l1Current != null || l2Current != null) {
      if (l1Current != null && l2Current != null) {
        currentSum = l1Current.val + l2Current.val + carryOver;
        l1Current = l1Current.next;
        l2Current = l2Current.next;
      } else if (l1Current != null) {
        currentSum = l1Current.val + carryOver;
        l1Current = l1Current.next;
        l2Current = null;
      } else {
        currentSum = l2Current.val + carryOver;
        l1Current = null;
        l2Current = l2Current.next;
      }
      carryOver = 0;
      if (currentSum > 9) {
        currentSum -= 10;
        carryOver = 1;
      }
      if (isFirstPass) {
        rootNode.val = currentSum;
        isFirstPass = false;
      } else {
        currentSumNode.next = new ListNode(currentSum);
        currentSumNode = currentSumNode.next;
      }
    }
    if (carryOver == 1) {
      currentSumNode.next = new ListNode(1);
    }
    return rootNode;
  }

}
