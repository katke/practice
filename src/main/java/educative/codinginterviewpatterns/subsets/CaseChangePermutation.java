package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;

public class CaseChangePermutation {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * 2^n)";
  String spaceComplexity = "O(2^n)";
  /*
  * Given a string, find all of its permutations preserving the character sequence but changing case.
  * Input: "ad52"
  * Output: "ad52", "Ad52", "aD52", "AD52"
  * */
  List<String> solution(String str) {
    if (str == null || str.length() == 0) return List.of();
    List<String> result = new ArrayList<>();
    result.add(str);
    int strIndex = 0;
    while (strIndex < str.length()) {
      char currentChar = str.charAt(strIndex);
      int resultIndex = 0;
      List<String> newPermutations = new ArrayList<>();
      if (Character.isLetter(currentChar)) {
        char newChar = Character.isUpperCase(currentChar)
            ? Character.toLowerCase(currentChar)
            : Character.toUpperCase(currentChar);
        while (resultIndex < result.size()) {
          String currentResult = result.get(resultIndex);
          String newPermutation = String.format("%s%s%s",
              currentResult.substring(0, strIndex),
              newChar,
              currentResult.substring(strIndex+1, str.length()));
          newPermutations.add(newPermutation);
          resultIndex++;
        }
      }
      strIndex++;
      result.addAll(newPermutations);
    }
    return result;
  }

  List<String> recursiveSolution(String str) {
    if (str == null || str.length() == 0) return List.of();
    List<String> result = new ArrayList<>();
    result.add(str);
    findPermutation(str, 0, result);
    return result;
  }

  private void findPermutation(String str, int index, List<String> result) {
    if (index == str.length()) return;
    char currentChar = str.charAt(index);
    if (Character.isLetter(currentChar)) {
      char newChar = Character.isUpperCase(currentChar)
          ? Character.toLowerCase(currentChar)
          : Character.toUpperCase(currentChar);
      int resultIndex = 0, resultSize = result.size();
      while (resultIndex < resultSize) {
        String basePermutation = result.get(resultIndex);
        String newPermutation = String.format("%s%s%s",
            basePermutation.substring(0, index),
            newChar,
            basePermutation.substring(index + 1, str.length()));
        result.add(newPermutation);
        resultIndex++;
      }
    }
    findPermutation(str, index + 1, result);
  }


}
