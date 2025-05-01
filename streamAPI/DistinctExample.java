package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctExample {
    public static void main(String[] args) {
        List<String> fruitsList = Arrays.asList("banana", "apple","banana","kiwi");
        List<String> orinigalFruitsList = fruitsList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(orinigalFruitsList);

        System.out.println("---------------------------------------------------");

        Set<String> fruits = fruitsList.stream().collect(Collectors.toSet());
        System.out.println("fruits:  "+fruits);
    }
}
