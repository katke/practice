package educative.codinginterviewpatterns;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomAsserts {

  public void assertListEquals(List<String> expected, List<String> actual) {
    assertEquals(expected.size(), actual.size());
    for (String expectedValue : expected) {
      System.out.println("expected: " + expectedValue);
      assertTrue(actual.contains(expectedValue));
    }
  }
}
