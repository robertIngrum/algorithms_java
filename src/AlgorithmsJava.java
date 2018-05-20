import algorithms.HeapSort;
import algorithms.InsertionSort;
import algorithms.QuickSort;

public class AlgorithmsJava {
  public static void main(String[] args) {
    String command  = args[0];
    String[] params = new String[args.length - 1];

    System.arraycopy(args, 1, params, 0, params.length);

    main(command, params);
  }

  private static void main(String command, String... args) {
    AlgorithmsJava wrapper = new AlgorithmsJava();

    switch (command) {
      case "insertionSort":
        printResult("InsertionSort result:", wrapper.insertionSort(args));
        break;
      case "heapSort":
        printResult("heapSort result:", wrapper.heapSort(args));
        break;
      case "quickSort":
        printResult("quickSort result:", wrapper.quickSort(args));
        break;
      case "radixSort":
        Integer[] numbers = new Integer[args.length];

        for (int i = 0; i < args.length; i++) { numbers[i] = Integer.parseInt(args[i]); }

        printResult("radixSort result:", wrapper.radixSort(numbers));
        break;
      default:
    }
  }

  @SuppressWarnings("WeakerAccess")
  public <T extends Comparable<T>> T[] insertionSort(T[] array) {
    return InsertionSort.apply(array);
  }

  @SuppressWarnings("WeakerAccess")
  public <T extends Comparable<T>> T[] quickSort(T[] array) {
    return QuickSort.apply(array);
  }

  @SuppressWarnings("WeakerAccess")
  public <T extends Comparable<T>> T[] heapSort(T[] array) {
    return HeapSort.apply(array);
  }

  @SuppressWarnings("WeakerAccess")
  public Integer[] radixSort(Integer[] array) {
    return HeapSort.apply(array);
  }

  private static <T> void printResult(String message, T[] array) {
    System.out.println(message);

    for (T entry : array) {
      System.out.println(entry);
    }
  }
}
