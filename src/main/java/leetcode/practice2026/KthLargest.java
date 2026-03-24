package leetcode.practice2026;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargest {
    final private String source = "https://leetcode.com/problems/kth-largest-element-in-a-stream";
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    final private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (this.minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (this.minHeap.size() > k) minHeap.remove();
        }
        return minHeap.peek();
    }

}
