import algorithms.InsertionSort;

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
        printResult(
            "InsertionSort result:",
            wrapper.insertionSort(args)
        );
        break;
      default:
    }
  }

  @SuppressWarnings("WeakerAccess")
  public <T extends Comparable<T>> T[] insertionSort(T[] array) {
    return InsertionSort.apply(array);
  }

  private static <T> void printResult(String message, T[] array) {
    System.out.println(message);

    for (T entry : array) {
      System.out.println(entry);
    }
  }
}
