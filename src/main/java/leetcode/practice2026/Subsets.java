package leetcode.practice2026;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

class Subsets {
    PracticeStatus status = PracticeStatus.ACCEPTED;
    String source = "https://leetcode.com/problems/subsets/";

    // Runtime: O(2^n * n)
    // Space:
    List<List<Integer>> solutionIterative(int[] nums) {
        if (nums == null || nums.length == 0) {
            return List.of(List.of());
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        for (int num : nums) {
            int currResultSize = result.size();
            for (int i = 0; i < currResultSize; i++) {
                List<Integer> resultArray = result.get(i);
                List<Integer> resultArrayCopy = new ArrayList<>(resultArray);
                resultArrayCopy.add(num);
                result.add(resultArrayCopy);
            }
        }
        return result;
    }
}
