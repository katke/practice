package leetcode.practice2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestItemInStreamTest {

    @Test
    void happyPathTest() {
        KthLargest testClass = new KthLargest(3, new int[]{4,5,8,2});
        int first = testClass.add(3);
        assertEquals(4, first);
        int second = testClass.add(5);
        assertEquals(5, second);
        int third = testClass.add(10);
        assertEquals(5, third);
        int fourth = testClass.add(9);
        assertEquals(8, fourth);
        int fifth = testClass.add(4);
        assertEquals(8, fifth);
    }

    @Test
    void happyPathTest2() {
        KthLargest testClass = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        int first = testClass.add(2);
        assertEquals(7, first);
        int second = testClass.add(10);
        assertEquals(7, second);
        int third = testClass.add(9);
        assertEquals(7, third);
        int fourth = testClass.add(9);
        assertEquals(8, fourth);
    }
}
