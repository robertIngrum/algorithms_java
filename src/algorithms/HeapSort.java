package algorithms;

/**
 * Heap Sort
 *
 * Not stable, don't use when the order of identical elements needs to be preserved.
 * Only really useful on heaps.
 *
 * Time Complexity:  O(NlogN)
 * Space Complexity: O(1)
 */
public interface HeapSort {

  static <T extends Comparable<T>> T[] apply(T[] array) {

    heapify(array);

    int lastUnsortedIndex = array.length - 1;
    while (lastUnsortedIndex > 0) {
      promoteMax(array, lastUnsortedIndex);

      swap(array, 0, lastUnsortedIndex);

      lastUnsortedIndex--;
    }

    return array;
  }

  private static <T extends Comparable<T>> void heapify(T[] array) {
    heapify(array, array.length - 1);
  }

  private static <T extends Comparable<T>> void heapify(T[] array, int rootIndex) {
    // TODO: This doesn't seem like the best implementation

    if (rootIndex < 0) { return; }

    promoteMax(array, rootIndex, array.length - 1);

    heapify(array, rootIndex - 1);
  }

  private static <T extends Comparable<T>> void promoteMax(T[] array, int lastIndex) {
    promoteMax(array, 0, lastIndex);
  }

  private static <T extends Comparable<T>> void promoteMax(T[] array, int rootIndex, int lastIndex) {
    if (lastIndex <= rootIndex * 2) { return; }

    int maxIndex = rootIndex;

    int aIndex = rootIndex * 2 + 1;
    if (array[maxIndex].compareTo(array[aIndex]) < 0) { maxIndex = aIndex; }

    if (lastIndex > aIndex) {
      int bIndex = aIndex + 1;

      if (array[maxIndex].compareTo(array[bIndex]) < 0) { maxIndex = bIndex; }
    }

    if (maxIndex == rootIndex) { return; }

    swap(array, rootIndex, maxIndex);
    promoteMax(array, maxIndex, lastIndex);
  }

  private static <T> void swap(T[] array, int index1, int index2) {
    if (index1 == index2) { return; }

    T temp        = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
