package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class MaxUniqueConcatString {
  String source = "https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O((2^n * n) + (n*m)) where m = length of strings in array";
  String spaceComplexity = "O(2^n)";
  /*
  * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr
  * that has unique characters.

  * Return the maximum possible length of s.
  *
  * A subsequence is an array that can be derived from another array by deleting some or no elements without
  * changing the order of the remaining elements.
  *
1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters
  * */
  int solution(List<String> arr) {
    if (arr == null || arr.size() == 0) return 0;
    Map<String, Set<Character>> uniqueCharsMap = initializeSets(arr);
    int max = 0;
    List<String> subsets = new ArrayList<>();
    subsets.add("");
    for (String str : arr) {
      var subsetsSize = subsets.size();
      for (int i = 0; i < subsetsSize; i++) {
        var current = subsets.get(i);
        if (isValidConcat(current, str, uniqueCharsMap)) {
          subsets.add(current.concat(str));
          max = Math.max(max, str.length() + current.length());
        }
      }
    }
    return max;
  }

  boolean isValidConcat(String uniqueString, String newSubString, Map<String,Set<Character>> map) {
    if (!map.containsKey(newSubString)) return false;
    Set<Character> newChars = map.get(newSubString);
    for (Character character : uniqueString.toCharArray()) {
      if (newChars.contains(character)) {
        return false;
      }
    }
    return true;
  }

  Map<String,Set<Character>> initializeSets(List<String> arr) {
    // n * m time (m=string length) to build, but will be O(1) lookup later
    Map<String,Set<Character>> chars = new HashMap<>();
    for (String str : arr) {
      var set = new HashSet<Character>();
      for (int i = 0; i < str.length(); i++) {
        set.add(str.charAt(i));
      }
      if (set.size() == str.length()) {
        chars.put(str, set);
      }
    }
    return chars;
  }
}
