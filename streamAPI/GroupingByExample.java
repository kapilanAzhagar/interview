package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/****
 * collectors.groupingby(e->Collectors.counting)
 */
public class GroupingByExample {
    public static void main(String[] args) {

        List<String> fruitsList = Arrays.asList("Apple", "Banana","kiwi","apple","banana");
        Map<String, Long> fruitsResult = fruitsList.stream()
                 .map(String::toUpperCase)
                .collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(fruitsResult);
    }
}
