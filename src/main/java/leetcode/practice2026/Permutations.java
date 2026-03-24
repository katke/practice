package leetcode.practice2026;

import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(
            List<Integer> curr,
            List<List<Integer>> ans,
            int[] nums
    ) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> iterative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsets.add(new ArrayList<>());
//        Deque<List<Integer>> queue = new ArrayDeque<>();
//        queue.addLast(new ArrayList<>());
        for (int num: nums) {
            int currSubsets = subsets.size();
            for (int i = 0; i < currSubsets; i++) {
                List<Integer> currSubset = new ArrayList<>(subsets.get(i));
                currSubset.add(num);
                subsets.add(currSubset);
                if (currSubset.size() == nums.length) {
                    result.add(currSubset);
                }
            }
        }
        return result;
    }
}
