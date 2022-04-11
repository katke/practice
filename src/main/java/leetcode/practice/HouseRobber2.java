package leetcode.practice;

import shared.PracticeStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber2 {
  String source = "https://leetcode.com/problems/house-robber-ii/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
You are a professional robber planning to rob houses along a street. Each house has a certain
amount of money stashed. All houses at this place are arranged in a circle. That means the
first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system
connected, and it will automatically contact the police if two adjacent houses were broken
into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum
amount of money you can rob tonight without alerting the police.
*/
  Map<Integer, Integer> memo = new HashMap<>();
  int solution(int[] nums) {
    System.out.println(Arrays.toString(nums));
    if (nums == null || nums.length == 0) return 0;
    else if (nums.length == 1) return nums[0];
    return robHouse(0, nums);
  }

  int robHouse(int house, int[] houses) {
    System.out.println("robHouse() " + house);
    if (house >= houses.length) {
      // we've gone past the end of the array/street, so no additional value can be found
      System.out.println(memo);
      return 0;
    } else {
      // save ourselves from having to check the max value from a particular index more than once
      if (memo.containsKey(house)) {
        System.out.println(memo);
        return memo.get(house);
      }
      // Here's the bulk of the work. While we're standing at particular point (i.e. index), we have
      // two decisions: Rob the next house, or the one after it (can't do both due to alarm system)
      // We need to know the max value we'd get from doing one or the other
      // IMPORTANT: if we rob the second house, we also add on the value of this current house since
      // they are not right next to each other. If we rob the next house, we don't because that would mean
      // we're robbing two houses in a row
      var result = Math.max(robHouse(house + 1, houses), robHouse(house + 2, houses) + houses[house]);
      // we now know whether we will make more by skipping the current hosue and only going into the first house
      // OR by going into the current house and the second house. We will update our memo map accordingly so we
      // have to keep rechecking these house/index values again
      memo.put(house, result);
      System.out.println(memo);
      return result;

    }
  }
}
