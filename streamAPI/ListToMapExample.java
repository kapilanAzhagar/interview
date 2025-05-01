package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ap","tn","ka","kerala");
        Map<String,Integer> stateMap = stringList.stream()
                .sorted()
                .collect(Collectors.toMap(name->name,value->value.length()));
        System.out.println("stateMap : "+stateMap);
    }
}
