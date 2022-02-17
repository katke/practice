package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.*;

public class PhoneNumCombos {
  /*
   * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
   * that the number could represent. Return the answer in any order.
   * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
   * does not map to any letters.
   * */

  private static final Map<String, List<String>> digitMap = Map.of(
      "2", List.of("a", "b", "c"),
      "3", List.of("d", "e", "f"),
      "4", List.of("g", "h", "i"),
      "5", List.of("j", "k", "l"),
      "6", List.of("m", "n", "o"),
      "7", List.of("p", "q", "r", "s"),
      "8", List.of("t", "u", "v"),
      "9", List.of("w", "x", "y", "z")
  );

  public List<String> solution(String digits) {
    if (digits == null || digits.length() == 0) return List.of();
    List<String> result = new ArrayList<>();
    // queue will store each of the interim combinations while we are still building them
    Deque<String> queue = new ArrayDeque<>();
    queue.addLast("");
    for (String digit : digits.split("")) {
      // queue size = number of current interim permutations which will then need to be
      // copied and appended with next letter
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        // the base permutations which we will add on to in the next loop
        var currPermutation = queue.removeFirst();
        for (String letter : digitMap.get(digit)) {
          var newCombo = currPermutation + letter;
          // see if all expected digits are accounted for in this new permutation,
          // if so, we're done with this one and can add to result
          // otherwise, add a new interim permutation to our queue to be copied and added
          // to in future iterations
          if (newCombo.length() == digits.length()) {
            result.add(newCombo);
          } else {
            queue.addLast(newCombo);
          }
        }
      }
    }
    return result;
  }

  List<String> recursiveSolution(String input) {
    if (input == null || input.length() == 0) return List.of();
    List<String> result = new ArrayList<>();
    addPermutation(result, 0, input, "");
    return result;
  }

  void addPermutation(List<String> result, int index, String input, String currentPermutation) {
    // base case: Our permutation is complete, add to result and terminate
    if (currentPermutation.length() == input.length()) {
      result.add(currentPermutation);
      return;
    }
    for (String letter : digitMap.get(Character.toString(input.charAt(index)))) {
      // building on the current permutation with a new letter
      var newCombo = currentPermutation + letter;
      addPermutation(result, index + 1, input, newCombo);
    }
  }


}
