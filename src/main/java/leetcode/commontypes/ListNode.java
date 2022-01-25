package leetcode.commontypes;

// LeetCode given type definition for singly-linked list
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public String toStringRepresentation() {
          String template = "Node with value %d%s";
          return String.format(template,
              this.val,
              this.next == null ? ", points to: null node" : "");
     }
}
