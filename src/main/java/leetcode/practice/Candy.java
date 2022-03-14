package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class Candy {
  String source = "https://leetcode.com/problems/candy/";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_TIME_OPTIMIZATION;
  String timeComplexity = "O(n^2)";
  String spaceComplexity = "O(n)";
  /*
  * There are n children standing in a line. Each child is assigned a rating value
  * given in the integer array ratings.
  * You are giving candies to these children subjected to the following requirements:
  *   Each child must have at least one candy.
  *   Children with a higher rating get more candies than their neighbors.
  *
  * Return the minimum number of candies you need to have to distribute the candies to the children.
  * */

  public int solution(int[] ratings) {
    if (ratings == null) return 0;
    else if (ratings.length < 2) return ratings.length;
    System.out.println(Arrays.toString(ratings));
    Map<Integer, Integer> distribution = initializeDistribution(ratings.length);
    boolean distributionUpdate = true;
    while (distributionUpdate) {
      distributionUpdate = false;
      for (int i = 0; i < ratings.length; i++) {
        System.out.println("i: " + i + ", rating: " + ratings[i]);
        if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && distribution.get(i) <= distribution.get(i + 1)) {
//          candies[i] = candies[i + 1] + 1;
          System.out.println("First condition: current rating > next rating, and current distribution <= next distribution");
          distribution.put(i, distribution.get(i + 1) + 1);
          distributionUpdate = true;
        }
        System.out.println(distribution);
        if (i > 0 && ratings[i] > ratings[i - 1] && distribution.get(i) <= distribution.get(i - 1)) {
//          candies[i] = candies[i - 1] + 1;
          System.out.println("Second condition: current rating > previous rating, and current distribution <= previous distribution");
          distribution.put(i, distribution.get(i - 1) + 1);
          distributionUpdate = true;
          }
        System.out.println(distribution);
        System.out.println("-".repeat(10));
      }
    }
    System.out.println(distribution);
    return calculateTotalMin(distribution);
  }

  Map<Integer, Integer> initializeDistribution(int numChildren) {
    Map<Integer, Integer> distribution = new HashMap<>();
    for (int i = 0; i < numChildren; i++) {
      distribution.put(i, 1);
    }
    return distribution;
  }

  int calculateTotalMin(Map<Integer, Integer> distribution) {
    return distribution.values().stream().reduce(Integer::sum).orElse(0);
  }
}
