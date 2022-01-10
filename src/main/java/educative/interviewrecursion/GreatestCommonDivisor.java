package educative.interviewrecursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GreatestCommonDivisor {
  int gcd(int num1, int num2) {
    if (num1 == 0 || num2 == 0) {
      return -1;
    } else if (num1 == num2) return num1;
    Map<Integer, Integer> allDivisors = new HashMap<>();
    allDivisors.put(num1, 1);
    allDivisors.put(num2, 1);
    findDivisor(num1, num1 / 2, allDivisors);
    findDivisor(num2, num2 / 2, allDivisors);
    return findGreatestCommonDivisor(allDivisors).getKey();
  }

  void findDivisor(int num, int currentDivisor, Map<Integer, Integer> allDivisors) {
    System.out.println("num: " + num + " currentDivisor: " + currentDivisor);
    if (currentDivisor == 0) return;
    if (num % currentDivisor == 0) {
      allDivisors.compute(currentDivisor, (key, val) -> val == null ? 1 : val + 1);
      var otherDivisor = num / currentDivisor;
      allDivisors.compute(otherDivisor, (key, val) -> val == null ? 1 : val + 1);
    }
    findDivisor(num, currentDivisor / 2, allDivisors);
  }

  Map.Entry<Integer, Integer> findGreatestCommonDivisor(Map<Integer, Integer> commonDiv) {
    Optional<Map.Entry<Integer, Integer>> largestEntry = commonDiv.entrySet().stream()
        .filter(entry -> entry.getValue() == 2)
        .reduce((prev, next) -> {
          var largerDivisor = Math.max(prev.getKey(), next.getKey());
          return largerDivisor == prev.getKey() ? prev : next;

        });
    return largestEntry.orElse(Map.entry(-1, -1));
  }
}
