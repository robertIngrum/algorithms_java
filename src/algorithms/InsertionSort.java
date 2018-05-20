package algorithms;

/**
 * Insertion Sort
 *
 * Useful when the number of elements is small or the input array is nearly sorted.
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(1)
 */
public interface InsertionSort {

  static <T extends Comparable<T>> T[] apply(T[] array) {
    int length = array.length;

    for (int i = 1; i < length; i++) {
      int key = i;

      for (int j = key - 1; j >= 0; j--) {

        int pair_comparison = array[key].compareTo(array[j]);

        if (pair_comparison < 0) {
          swap(array, key, j);
          key--;
        }
      }
    }

    return array;
  }

  private static <T> void swap(T[] array, int index1, int index2) {
    if (index1 == index2) { return; }

    T temp        = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
