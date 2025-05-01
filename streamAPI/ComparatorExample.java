package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Humans{
    private String name;
    private int age;

    Humans(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Humans{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparatorExample {
    public static void main(String[] args) {

        List<Humans> employeeList = Arrays.asList(
                new Humans("kapil",24),
                new Humans("lakshmi",45),
                new Humans("dudu",1)
        );

        List<Humans> sortedList = employeeList.stream()
                .sorted((o1,o2)->Integer.compare(o1.getAge(), o2.getAge()))
                .collect(Collectors.toList());

        List<Humans> resultList = employeeList.stream()
                        .sorted(Comparator.comparing(person->person.getAge()))
                        .collect(Collectors.toList());

        System.out.println("sorted List :"+sortedList);
        System.out.println("----------------------------------");
        System.out.println("sorted List :"+resultList);



    }
}
