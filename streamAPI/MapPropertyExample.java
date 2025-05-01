package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class MapPropertyExample {
    public static void main(String[] args) {

        List<Person> persList = Arrays.asList(
                new Person("kapilan",35),
                new Person("baby",32),
                new Person("dudu",1));


        List<String> namesList  = persList.stream()
                .map(person->person.getName()).collect(Collectors.toList());

        String names = persList.stream()
                .map(person->person.getName()).collect(Collectors.toList())
                .stream().collect(Collectors.joining("+"));

        System.out.println("NamesList: "+namesList);
        System.out.println("Names joined : "+names);



    }
}
