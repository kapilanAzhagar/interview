package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/****
 *  From collections
 *  From arrays
 *  Stream.of()
 *  Stream.generate
 *  Stream.iterate
 */
public class StreamCreationExample {

    public static void main(String[] args) {

        List<String> namesList = Arrays.asList("Daily", "Weekly");

        //From collections
        namesList.stream().forEach(System.out::println);

        //from arrays
        Stream<Integer>orderItems = Stream.of(1,2,4);
        orderItems.forEach(System.out::println);

        //from generate
        Stream.generate(Math::random)
                .limit(3)
                .forEach(System.out::println);

        //from iterate
        Stream.iterate(1,n->n+2).limit(5).forEach(System.out::println);

    }
}
