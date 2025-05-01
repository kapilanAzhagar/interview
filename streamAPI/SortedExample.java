package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

    public static void main(String[] args) {
        List<String> productsList = Arrays.asList("furniture", "Mobile","clothing","Accessories");
        productsList.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);



        //productsList.stream().sorted((o1, o2) -> o2>o1?)
    }
}
