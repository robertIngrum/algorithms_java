package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

  @Test
  void itShouldSortAListOfStrings() {
    String[] strings = { "kmasd", "dfsd", "eesdf", "asde", "efs", "zzzz", "rasde", "erwaa", "l", "modp", "a", "hey" };
    String[] ordered = Arrays.copyOf(strings, strings.length);
    Arrays.sort(ordered);

    HeapSort.apply(strings);

    assertTrue(Arrays.equals(strings, ordered));
  }

  @Test
  void itShouldSortAListOfIntegers() {
    // No sane language should do this.
    //   In Ruby, this is just `50.times.map { Random.rand(50) }`.
    //   I know Ruby is slow, but dream bigger.  Dealing with a shitty generic implementation
    //   and poor generics at the same time is nonsense.
    Integer[] numbers = new Random().ints(50, 0, 200).boxed().toArray(Integer[]::new);
    Integer[] ordered = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(ordered);

    HeapSort.apply(numbers);

    assertTrue(Arrays.equals(numbers, ordered));
  }


}
