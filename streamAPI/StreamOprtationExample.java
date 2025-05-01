package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** intermediate operation: filter, map, sorted
 * terminal operation: collect, foreach, reduce
 *
 *
 */
public class StreamOprtationExample {

    public static void main(String[] args) {

        List<String> phonesList = Arrays.asList("iphone", "samsung", "moto");
        phonesList.stream().filter(name->name.startsWith("s")).forEach(System.out::println);

        Set<String> resultList = phonesList.stream().filter(name->name.startsWith("i"))
                            .collect(Collectors.toSet());
        resultList.forEach(System.out::println);


    }
}
