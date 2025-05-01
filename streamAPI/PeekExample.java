package streamAPI;

import java.util.Arrays;
import java.util.List;

/****
 * peek-> used to debug + it allows you to look at the stream as flow through
 */
public class PeekExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("meenu", "baby", "meenakshi");
        List<String> result = names.stream()
                .filter(name->name.length()>5)
                .peek(System.out::println)
                .toList();
        System.out.println("Peeked output :"+result);
    }




}
