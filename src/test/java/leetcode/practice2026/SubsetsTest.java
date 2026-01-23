package leetcode.practice2026;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SubsetsTest  {
    Subsets subsets = new Subsets();

    @ParameterizedTest
    @MethodSource("testInput")
    void validateIterativeSolution(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> actual = subsets.solutionIterative(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                arguments(new int[]{1,2,3}, List.of(
                        List.of(),
                        List.of(1),
                        List.of(2),
                        List.of(1,2),
                        List.of(3),
                        List.of(1,3),
                        List.of(2,3),
                        List.of(1,2,3))),
                arguments(new int[]{0}, List.of(
                        List.of(), List.of(0)
                ))
        );
    }

}
