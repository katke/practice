package educative.interviewrecursion;

import shared.PracticeStatus;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GreatestCommonDivisor {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/recursion-for-coding-interviews-in-java/mEr5lrNqYp0";
  String timeComplexity = "O(n / 2), where n = the larger of the two inputs";
  String spaceComplexity = "O(n), where n = the larger of the two inputs";

  // Apparently assume only int inputs >= 0

  int gcd(int num1, int num2) {
    if (num1 == 0 || num2 == 0) {
      return 0;
    }
    Map<Integer, Set<Integer>> allDivisors = new HashMap<>();
    allDivisors.put(num1, new HashSet<>());
    allDivisors.put(num2, new HashSet<>());
    findDivisor(num1, num1 / 2,  allDivisors);
    findDivisor(num2, num2 / 2, allDivisors);
    return findGreatestCommonDivisor(allDivisors.get(num1), allDivisors.get(num2));
  }

  void findDivisor(int num, int currentDivisor, Map<Integer, Set<Integer>> allDivisors) {
    if (currentDivisor == 0) return;
    if (num % currentDivisor == 0) {
      allDivisors.get(num).add(currentDivisor);
      var correspondingDivisor = num / currentDivisor;
      allDivisors.get(num).add(correspondingDivisor);
    }
    findDivisor(num, currentDivisor - 1, allDivisors);
  }

  // TODO could incorporate into main logic
  Integer findGreatestCommonDivisor(Set<Integer> num1Divisors, Set<Integer> num2Divisors) {
    AtomicInteger largestCommonDivisor = new AtomicInteger(Integer.MIN_VALUE);
    num1Divisors.forEach(divisor -> {
      if (num2Divisors.contains(divisor)) {
        largestCommonDivisor.set(Math.max(divisor, largestCommonDivisor.get()));
      }
    });
    return largestCommonDivisor.get();
  }
}