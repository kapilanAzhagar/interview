package designPatterns;
//building the complex objects step by step and make sure its immutable and code looks well with good readability with maintainable.

import com.sun.tools.javac.Main;

class Meal{
    private MainCourse mainCourse;
    private Starter starter;
    private Dessert dessert;

    public Meal(MainCourse mainCourse, Starter starter, Dessert dessert){
        this.mainCourse = mainCourse;
        this.starter = starter;
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mainCourse=" + mainCourse +
                ", starter=" + starter +
                ", dessert=" + dessert +
                '}';
    }
}
class MainCourse{
    private String mainCourseName;
    private int count;
    private double price;

    public MainCourse(String mainCourseName, int count, double price) {
        this.mainCourseName = mainCourseName;
        this.count = count;
        this.price = price;
    }

    public String getMainCourseName() {
        return mainCourseName;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MainCourse{" +
                "mainCourseName='" + mainCourseName + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
class Starter{
    private String name;
    private int count;

    public Starter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Starter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
class Dessert{
    private int count;
    private String name;

    public Dessert(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}

class MealBuilder{
    private MainCourse mainCourse;
    private Starter starter;
    private Dessert dessert;

    public MealBuilder setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    public MealBuilder setStarter(Starter starter) {
        this.starter = starter;
        return this;
    }

    public MealBuilder setDessert(Dessert dessert) {
        this.dessert = dessert;
        return this;
    }
    public Meal build(){
        return new Meal(mainCourse,starter,dessert);
    }
}

public class BuilderDesignPattern {
    public static void main(String[] args) {
        MainCourse mainCourse = new MainCourse("Biriyani",2,400);
        Starter starter = new Starter("kabab",3);
        Dessert dessert = new Dessert(10,"jamun");
        Meal meal = new MealBuilder()
                .setMainCourse(mainCourse)
                .setStarter(starter)
                .setDessert(dessert)
                .build();
        System.out.println("Meals Added:"+meal.toString());

    }

}
