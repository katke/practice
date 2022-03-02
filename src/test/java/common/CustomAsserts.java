package common;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomAsserts {

  // Only if order doesn't matter
  public void assertListEquals(List<?> expected, List<?> actual) {
    assertEquals(expected.size(), actual.size());
    for (Object expectedValue : expected) {
      System.out.println("expected: " + expectedValue);
      assertTrue(actual.contains(expectedValue));
    }
  }
}
