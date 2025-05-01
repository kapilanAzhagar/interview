package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/****
 * .reduce -> sum+multiplication+ concantation
 * it allows multiple elements into single element.
 */
public class ReduceExample {

    public static void main(String[] args) {

        List<Integer> orders = Arrays.asList(1,4,5,7,7);
        Integer result = orders.stream().reduce(0,(a,b)->a+b);
        System.out.println("result: "+result);

        List<String> greetingsList = Arrays.asList("Hello","good morning", "kapilan");
        Optional<String> greet = greetingsList.stream().reduce((str1, str2)->str1+str2);
        greet.ifPresent(System.out::println);

        //find the max number
        List<Integer> numbersList = Arrays.asList(345,656,767,34343,3,454656);
        Integer maximumValue = numbersList.stream().max(Integer::compare).get();
        System.out.println(maximumValue);
        System.out.println("--------------------------------------");
        //longest string using stream api
        List<String> sourceData = Arrays.asList("kapil","baby","dudu");
        String maxString = sourceData.stream().reduce("",(name1,name2)->name1.length()>name2.length()?name1:name2);
        System.out.println(maxString);


    }

}
