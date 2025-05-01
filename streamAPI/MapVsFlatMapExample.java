package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****
 * Map -> Transform an element + Stream<Stream<T></T>>
 * FlatMap -> transforms an element and flattans the result.
 */
public class MapVsFlatMapExample {

    public static void main(String[] args) {
        List<List<String>> namesList = Arrays.asList(
                Arrays.asList("kapil"),
                Arrays.asList("Meenakshi"),
                Arrays.asList("Hariharan"));

        //map example

        namesList.stream()
                .map(List::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("return size: "+namesList.size());
        //flatmap

        namesList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                . forEach(System.out::println);
    }




}
