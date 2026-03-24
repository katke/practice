package leetcode.practice2026;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PriorityQueueQ {

    List<Integer> testingWhatItReturns(List<Integer> nums) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        String key = "blah";
        map.put(key, "something");
        map.putIfAbsent(key, "test");
        map.computeIfAbsent("blah2", this::doAThing);
        PriorityQueue<Integer> test = new PriorityQueue<>();
        PriorityQueue<Integer> test2 = new PriorityQueue<>(Collections.reverseOrder());
        test2.addAll(nums);
        var result = new ArrayList<Integer>();
        for (Integer num : nums) {
            result.add(test2.remove());
        }
        return result;
    }

    private String doAThing(String key) {
        return Integer.toString(key.length());
    }
}
