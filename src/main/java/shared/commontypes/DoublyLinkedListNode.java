package shared.commontypes;

public class DoublyLinkedListNode {
    public final int key;
    public int val;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key, int val, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public DoublyLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    public boolean isHead() {
        return this.next != null && this.prev == null;
    }

    public boolean isTail() {
        return this.prev != null && this.next == null;
    }
}
