package leetcode.practice2026;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationsTest {
    private final Permutations permutations = new Permutations();

    @Test
    void itDoesTheThing() {
        List<List<Integer>> result = permutations.permute(new int[]{1,2,3});
        List<List<Integer>> expected = List.of(List.of(1,2,3),List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1));
        assertEquals(expected.size(), result.size());
        for (List<Integer> permutation : result) {
            assertTrue(expected.contains(permutation));
        }
    }

    @Test
    void itStillDoesTheThing() {
        List<List<Integer>> result = permutations.iterative(new int[]{1,2,3});
        List<List<Integer>> expected = List.of(List.of(1,2,3),List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1));
        assertEquals(expected.size(), result.size());
        for (List<Integer> permutation : result) {
            assertTrue(expected.contains(permutation));
        }
    }
}
