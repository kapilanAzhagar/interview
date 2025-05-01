package streamAPI;

import java.util.Arrays;
import java.util.List;

public class streamAPI {
    /******
     *  new abstraction + process the collection of objects functionally instead of imperatively
     *  filter, map,reduce, collect operations.
     *  Streams doesnot store date, they process it.
     */


    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Kapilan", "Meenakshi", "Hariharan");
        namesList.stream()
                .forEach((name)-> System.out.println(name));
        namesList.stream()
                .forEach(System.out::println);

        for(String name:namesList){
            System.out.println("External ireration: "+name);
        }

        namesList.stream().forEach(System.out::println);

    }
}
