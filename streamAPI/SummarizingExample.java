package streamAPI;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingExample {

    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(34,12,50,40,100,45);

        IntSummaryStatistics statistics = numbersList.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Maximum value :"+statistics.getMax());
        System.out.println("Minimum value :"+statistics.getMin());
        System.out.println("Average value :"+statistics.getAverage());
        System.out.println("sum value :"+statistics.getSum());

    }
}
