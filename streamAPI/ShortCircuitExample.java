package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ShortCircuitExample {
    public static void main(String[] args) {
        //findfirst
        List<String> fruitsList = Arrays.asList("apple","banana","kiwi","apple");

        String fruitName = fruitsList.stream()
                .filter(fruit->fruit.startsWith("a"))
                .findFirst().toString();
        System.out.println("fruitname: "+fruitName);
        System.out.println("------------------------------------------------");

        //findAny
        //same as above

        //anyfirst

        List<Integer> orders = Arrays.asList(23,45,56,88,56,90);
        boolean isEvenNoAvailable = orders.stream().anyMatch(number->number % 2==0);
        System.out.println("isEvenNoAvailable :"+isEvenNoAvailable);


        //all match
        List<Integer> rollNums = Arrays.asList(10,20,40,60);
        boolean allAreEven = rollNums.stream().allMatch(number->number %2 ==0);
        System.out.println("all are even: "+allAreEven);
        System.out.println("--------------------");
        //reverseword using stream

        String sonName = "Hariharan";
        char[] list = sonName.toCharArray();

        for(int i=list.length-1;i>0;i--){
            System.out.println(list[i]);
        }






    }
}
