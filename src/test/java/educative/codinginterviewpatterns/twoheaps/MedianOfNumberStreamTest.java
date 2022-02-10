package educative.codinginterviewpatterns.twoheaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianOfNumberStreamTest {
  MedianOfNumberStream medianOfNumberStream = new MedianOfNumberStream();

  @Test
  void testSolution() {
    assertThrows(IllegalStateException.class, () -> medianOfNumberStream.findMedian());
    medianOfNumberStream.insertNum(3);
    medianOfNumberStream.insertNum(1);
    assertEquals(2.0, medianOfNumberStream.findMedian());
    medianOfNumberStream.insertNum(5);
    assertEquals(3.0, medianOfNumberStream.findMedian());
    medianOfNumberStream.insertNum(4);
    assertEquals(3.5, medianOfNumberStream.findMedian());
  }
}
