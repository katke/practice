package leetcode.practice2026;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OceanWaterFlowTest {
    private final OceanWaterFlow oceanWaterFlow = new OceanWaterFlow();

    @Test
    void itWorks() {
        int[][] heights = new int[][]{
                new int[]{1,2,2,3,5},
                new int[]{3,2,3,4,4},
                new int[]{2,4,5,3,1},
                new int[]{6,7,1,4,5},
                new int[]{5,1,1,2,4}};
         List<List<Integer>> expectedResult = List.of(
                 List.of(0,4),
                 List.of(1,3),
                 List.of(1,4),
                 List.of(2,2),
                 List.of(3,0),
                 List.of(3,1),
                 List.of(4,0));
         List<List<Integer>> actualResult = oceanWaterFlow.solution(heights);
         assertEquals(expectedResult.size(), actualResult.size());
        for (List<Integer> coordinates : expectedResult) {
            assertTrue(actualResult.contains(coordinates));
        }
    }
}
