package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Radix Sort
 *
 * Used to sort integers in linear time in range from 1 to n^2 where n is the length of the array
 *
 * Time Complexity:  O(~nlogn) or O(n(k/d))
 * Space Complexity: O(n+2^d)
 */
public interface RadixSort {

  static Integer[] apply(Integer[] array) {
    int maxDigit = findMaxDigit(array);

    for (int counter = 1; counter <= maxDigit; counter++) {
      array = sort(array, counter);
    }

    return array;
  }

  private static int findMaxDigit(Integer[] array) {
    int maxDigit = 1;
    int counter  = 0;

    while (counter < array.length) {
      if (array[counter] / Math.pow(10, maxDigit + 1) >= 1) {
        maxDigit++;
        counter = 0;
      } else {
        counter++;
      }
    }

    return maxDigit + 1;
  }

  private static Integer[] sort(Integer[] array, int digitIndex) {
    IntUnaryOperator digitVal = operand -> {
      int sigFig  = (int) Math.pow(10, digitIndex);
      int sigTrim = Math.max(sigFig / 10, 1);

      return operand % sigFig / sigTrim;
    };

    Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < 10; i++) { counts.put(i, 0); }

    for (Integer val : array) {
      counts.merge(digitVal.applyAsInt(val), 1, Integer::sum);
    }

    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += counts.get(i);
      counts.put(i, sum);
    }

    Integer[] result = new Integer[array.length];
    for (int i = array.length - 1; i >= 0; i--) {
      Integer val = array[i];
      int digit   = digitVal.applyAsInt(val);
      int index   = counts.get(digit) - 1;

      counts.merge(digit, -1, Integer::sum);

      result[index] = val;
    }

    return result;
  }
}
