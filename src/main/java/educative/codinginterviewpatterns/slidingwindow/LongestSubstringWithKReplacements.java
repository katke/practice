package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

import java.util.*;

public class LongestSubstringWithKReplacements {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(26 * n) aka O(n)";
  String spaceComplexity = "O(26) aka O(1)";
  /*
  * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter,
  * find the length of the longest substring having the same letters after replacement.
  * Ex "abbcb", k=1 => 4 ("bbbb")
  * */

  int findLength(String str, int k) {
    Set<Character> allPresentChars = getUniqueChars(str);
    int maxLength = -1;
    for (char currAnchorChar : allPresentChars) {
      int left = 0, right = 0, kReplacementsUsed = 0;
      while (left < str.length()) {

        if (kReplacementsUsed < k) {
          // there's still room for more replacements
          // expand window, increment right and otherCharsCount
          // add new right item to map
          maxLength = Math.max(maxLength, right - left + 1);
          if (right < str.length() - 1) {
            right++;
            if (str.charAt(right) != currAnchorChar) {
              kReplacementsUsed++;
            }
          } else {
              // right is done, finish closing window from left
              if (str.charAt(left) != currAnchorChar) {
                kReplacementsUsed--;
              }
              left++;
            }
        } else {
          // we have too many items, contract from left
          // remove current left item from map
          // increment left
          // TODO consolidate duplicate logic
          if (str.charAt(left) != currAnchorChar) {
            kReplacementsUsed--;
          }
          left++;

        }
      }
    }
    return maxLength;
  }

  Set<Character> getUniqueChars(String inputStr) {
    Set<Character> characters = new HashSet<>();
    for (int i = 0; i < inputStr.length(); i++) {
      characters.add(inputStr.charAt(i));
    }
    return characters;
  }
}
