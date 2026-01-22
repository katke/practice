package leetcode.practice2026;

import shared.PracticeStatus;
import shared.commontypes.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

import static shared.PracticeStatus.ACCEPTED;
// Get/Put runtime: O(1)
// LRU cache space: O(capacity) => O(1) depending on how you look at it
class LRUCache {
    public PracticeStatus problemStatus = ACCEPTED;
    public String source = "https://leetcode.com/problems/lru-cache/description/";
    private final int capacity;
    private Map<Integer, DoublyLinkedListNode> cache;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // sentinel nodes
        this.head = new DoublyLinkedListNode(-1, -1);
        this.tail = new DoublyLinkedListNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedListNode accessedNode = cache.get(key);
            removeNodeFromLinkedList(accessedNode);
            addToEndOfList(accessedNode);
            this.cache.put(key, accessedNode);
            return accessedNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        if (cache.containsKey(key)) {
            DoublyLinkedListNode currentNode = cache.get(key);
            removeNodeFromLinkedList(currentNode);
            this.cache.remove(key);
        }
        if (cache.size() + 1 > this.capacity) {
            removeLeastRecentlyUsedFromCache();
        }
        cache.put(key, newNode);
        addToEndOfList(newNode);
    }

    private void removeNodeFromLinkedList(DoublyLinkedListNode currentNode) {
        DoublyLinkedListNode nextNode = currentNode.next;
        DoublyLinkedListNode prevNode = currentNode.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToEndOfList(DoublyLinkedListNode newNode) {
        DoublyLinkedListNode existingTailNode = this.tail.prev;
        newNode.prev = existingTailNode;
        existingTailNode.next = newNode;
        newNode.next = this.tail;
        this.tail.prev = newNode;
    }

    private void removeLeastRecentlyUsedFromCache() {
        DoublyLinkedListNode leastRecentlyUsed = this.head.next;
        DoublyLinkedListNode nextLeastRecentlyUsed = leastRecentlyUsed.next;
        this.head.next = nextLeastRecentlyUsed;
        nextLeastRecentlyUsed.prev = this.head;
        this.cache.remove(leastRecentlyUsed.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
