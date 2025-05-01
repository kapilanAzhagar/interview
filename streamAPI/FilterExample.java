package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6);

        //find the even numbers. use filter as the internediate function

        numbersList.stream()
                .filter((n)->n%2==0)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
