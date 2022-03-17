package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class MinDeletionsForUniqueChars {
  String source = "https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "Brute force: O(N + K^2), heap: O(n + K^2 log K)"; // K is the maximum possible number of distinct characters in s
  String spaceComplexity = "O(K)";
  /*
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example,
in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

1 <= s.length <= 105
s contains only lowercase English letters.
*/

  int solution(String s) {
    if (s == null || s.length() == 0) return 0;
    int deletionCount = 0;
    Map<Character, Integer> charCount = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      charCount.compute(currChar, (key, val) -> val == null ? 1 : val + 1);
    }
    Set<Integer> frequenciesPresent = new HashSet<>();
    for (int freqCount : charCount.values()) {
      while (frequenciesPresent.contains(freqCount)) {
        freqCount--;
        deletionCount++;
      }
      if (freqCount > 0) frequenciesPresent.add(freqCount);
    }
    return deletionCount;
  }


  int heapSolution(String s) {
    if (s == null || s.length() == 0) return 0;
    int deletionCount = 0;
    Map<Character, Integer> charCount = new HashMap<>();
    // needs to be a max heap, not min heap, since we're decrementing the counts as we go.
    // with a min heap, the smaller counts fall off first and decrementing the counts isn't complete
    PriorityQueue<Integer> frequencies = new PriorityQueue<>((a,b) -> b - a);
    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      charCount.compute(currChar, (key, val) -> val == null ? 1 : val + 1);
    }
    frequencies.addAll(charCount.values());
    if (frequencies.isEmpty()) return deletionCount;

    while (frequencies.size() > 1) {
      int minFrequency = frequencies.poll();
      if (minFrequency == frequencies.peek()) {
        deletionCount++;
        minFrequency--;
        if (minFrequency > 0) frequencies.add(minFrequency);
      }
    }
    return deletionCount;
  }

}
