package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

  @Test
  void itShouldSortAListOfIntegers() {
    Integer[] numbers = new Random().ints(50, 0, 1000).boxed().toArray(Integer[]::new);
    Integer[] ordered = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(ordered);

    numbers = RadixSort.apply(numbers);

    assertTrue(Arrays.equals(numbers, ordered));
  }

}
