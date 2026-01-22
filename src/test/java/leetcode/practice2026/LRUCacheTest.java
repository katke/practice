package leetcode.practice2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {
    @Test
    void validateLRUCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int firstFetch = cache.get(1);
        assertEquals(1, firstFetch);
        cache.put(3,3);
        int secondFetch = cache.get(2);
        assertEquals(-1, secondFetch);
        cache.put(4,4);
        int thirdFetch = cache.get(1);
        assertEquals(-1, thirdFetch);
        int fourthFetch = cache.get(3);
        assertEquals(3, fourthFetch);
        int fifthFetch = cache.get(4);
        assertEquals(4, fifthFetch);
    }

    @Test
    void validateLRUCacheHandlesCapacityOf1() {
        LRUCache cache = new LRUCache(1);
        cache.put(1,1);
        cache.put(2,2);
        int firstFetch = cache.get(1);
        assertEquals(-1, firstFetch);
        cache.put(3,3);
        int secondFetch = cache.get(2);
        assertEquals(-1, secondFetch);
        int thirdFetch = cache.get(3);
        assertEquals(3, thirdFetch);
        cache.put(3,15);
        int fourthFetch = cache.get(3);
        assertEquals(15, fourthFetch);
    }

    @Test
    void validateLRUCacheHandlesUpdates() {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        int firstFetch = cache.get(1);
        assertEquals(-1, firstFetch);
        cache.get(2);
        cache.put(5,5);

        // 3 should've just gotten evicted because we accessed 2
        int secondFetch = cache.get(3);
        assertEquals(-1, secondFetch);

        // 4 is on chopping block; update should push it back & the new value is accounted for; 2 gets the boot
        cache.put(4,25);
        cache.put(12,12);
        int thirdFetch = cache.get(4);
        assertEquals(25, thirdFetch);
        int fourthFetch = cache.get(2);
        assertEquals(-1, fourthFetch);
    }
}
