package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

  @Test
  void itShouldSortAListOfStrings() {
    String[] strings = { "kmasd", "dfsd", "eesdf", "asde", "efs", "zzzz", "rasde", "erwaa", "l", "modp", "a", "hey" };
    String[] ordered = Arrays.copyOf(strings, strings.length);
    Arrays.sort(ordered);

    QuickSort.apply(strings);

    assertTrue(Arrays.equals(strings, ordered));
  }

  @Test
  void itShouldSortAListOfIntegers() {
    Integer[] numbers = new Random().ints(50, 0, 200).boxed().toArray(Integer[]::new);
    Integer[] ordered = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(ordered);

    QuickSort.apply(numbers);

    assertTrue(Arrays.equals(numbers, ordered));
  }


}
