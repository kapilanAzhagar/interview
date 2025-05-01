package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipExample {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(23,34,55,32,56);
        marks.stream()
                .filter(mark->mark>35)
                .skip(1)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
        //find the first largest value in array
        marks.stream().sorted().skip(marks.size()-1).forEach(System.out::println);
        System.out.println("--------------------------------------");
        //find the second largest value in array.
        marks.stream().sorted().collect(Collectors.toList()).reversed().stream().skip(0).forEach(System.out::println);

    }
}
