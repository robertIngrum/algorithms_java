package algorithms;

/**
 * Quick Sort
 *
 * Typically very fast (O(nlogn)), but there edge cases where it is O(n^2)
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(n)
 */
public interface QuickSort {

  static <T extends Comparable<T>> T[] apply(T[] array) {
    sort(array, 0, array.length - 1);

    return array;
  }

  private static <T extends Comparable<T>> void sort(T[] array, int minIndex, int maxIndex) {
    if (minIndex >= maxIndex) { return; }

    int partitionIndex = partition(array, minIndex, maxIndex);

    sort(array, minIndex, partitionIndex - 1);
    sort(array, partitionIndex + 1, maxIndex);
  }

  // Uses last element as pivot
  private static <T extends Comparable<T>> int partition(T[] array, int minIndex, int maxIndex) {
    T pivot = array[maxIndex];

    int i = minIndex;

    for (int j = minIndex; j < maxIndex; j++) {
      if (array[j].compareTo(pivot) <= 0) {
        swap(array, i, j);
        i++;
      }
    }

    swap(array, i, maxIndex);

    return i;
  }

  private static <T> void swap(T[] array, int index1, int index2) {
    if (index1 == index2) { return; }

    T temp        = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

}
