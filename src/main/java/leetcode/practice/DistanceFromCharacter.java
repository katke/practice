package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceFromCharacter {
  String source = "https://leetcode.com/problems/shortest-distance-to-a-character/";
  /*
  * Given a string s and a character c that occurs in s, return an array of integers
  * where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence
  * of character c in s.
  * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
  * */

  int[] shortestToChar(String s, char c) {
    if (s == null) return new int[]{};
    int[] result = new int[s.length()];
    List<Integer> cIndices = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        cIndices.add(i);
      }
    }
    System.out.println("cIndices: " + cIndices.toString());
    int sIndex = 0, cIndex = 0;
    int nextC = cIndices.get(cIndex);
    int followingC = cIndices.size() > 1 ? cIndices.get(cIndex+1) : cIndices.get(cIndex);
    while (sIndex < s.length()) {
      if (sIndex == nextC && cIndex < cIndices.size() - 1) {
        cIndex++;
        nextC = cIndices.get(cIndex);
        followingC = cIndices.get(cIndex < cIndices.size() - 1 ? cIndex + 1 : cIndex);
      } else {
        result[sIndex] = Math.min(Math.abs(sIndex - nextC), Math.abs(sIndex - followingC));
      }
      sIndex++;
      System.out.println("sIndex: " + sIndex);
      System.out.println("cIndex: " + cIndex);
      System.out.println("nextC: " + nextC);
      System.out.println("followingC: " + followingC);
      System.out.println(Arrays.toString(result));
    }
    return result;
  }
}
