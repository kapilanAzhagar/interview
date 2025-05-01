package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullExample {
    public static void main(String[] args) {
        List<Integer>numbersList = Arrays.asList(23,null,34,null);

        numbersList.stream().filter(Objects::nonNull).forEach(System.out::println);
    }
}
