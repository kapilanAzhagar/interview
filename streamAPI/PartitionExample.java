package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/****
 * splits stream elements into two groups based on a condition.
 * collectors.partitioingby()
 */
public class PartitionExample {

    public static void main(String[] args) {
        List<Integer> rollnumbers = Arrays.asList(24,10,20,35,45,65,28);

        Map<Boolean,List<Integer>> partitionMap = rollnumbers.stream()
                        .collect(Collectors.partitioningBy(number-> number % 2 ==0));

        System.out.println("Partition by:  "+partitionMap);
    }
}
