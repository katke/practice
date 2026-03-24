package leetcode.practice2026;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PriorityQueueQTest {
    PriorityQueueQ testClass = new PriorityQueueQ();

    @Test
    void test() {
        List<Integer> test1 = List.of(300,1,-2);
        List<Integer> result = testClass.testingWhatItReturns(test1);
        System.out.println(result);
    }
}
