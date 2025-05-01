package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****
 *  collect - terminal operation used to transform stream to collection
 *  toList, toSet, joining, groupingby
 */
public class CollectExample {

    public static void main(String[] args) {
        List<String> laptopList = Arrays.asList("dell","apple","apple","imac","lenovo","HP","aanana");
        laptopList.stream()
                .map(String::toUpperCase)
                .filter(name->name.startsWith("A"))
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");

        laptopList.stream()
                .filter(name->name.startsWith("a"))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");
        String laptopNames = laptopList.stream()
                .collect(Collectors.joining("+"));
        System.out.println(laptopNames);

        System.out.println("------------------------------------");

        //laptopList.stream().collect(Collectors.groupingBy())





    }

}
