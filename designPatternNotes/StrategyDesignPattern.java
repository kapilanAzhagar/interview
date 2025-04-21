package designPatterns;

class MealCourse{
    private MainCourseForMeal mainCourseForMeal;
    private DessertForMeal dessertForMeal;
    private StarterForMeal starterForMeal;

    public MealCourse(MainCourseForMeal mainCourseForMeal, DessertForMeal dessertForMeal, StarterForMeal starterForMeal) {
        this.mainCourseForMeal = mainCourseForMeal;
        this.dessertForMeal = dessertForMeal;
        this.starterForMeal = starterForMeal;
    }

    public double getTotalPrice(){
        return mainCourseForMeal.getPrice()+starterForMeal.getPrice()+dessertForMeal.getPrice();
    }

    @Override
    public String toString() {
        return "MealCourse{" +
                "mainCourseForMeal=" + mainCourseForMeal +
                ", dessertForMeal=" + dessertForMeal +
                ", starterForMeal=" + starterForMeal +
                '}';
    }
}

class DessertForMeal{
    private String name;
    private int quanity;
    private double itemPerPrice;
    private pricingStrategy pricingStrategy;

    public DessertForMeal(String name, int quanity, double itemPerPrice,pricingStrategy pricingStrategy) {
        this.name = name;
        this.quanity = quanity;
        this.itemPerPrice = itemPerPrice;
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(){
        return pricingStrategy.priceOfAnItem(itemPerPrice, quanity);
    }


    @Override
    public String toString() {
        return "DessertForMeal{" +
                "name='" + name + '\'' +
                ", quanity=" + quanity +
                ", itemPerPrice=" + itemPerPrice +
                '}';
    }
}

class StarterForMeal{
    private String name;
    private int quantity;
    private double itemPerPrice;
    private pricingStrategy pricingStrategy;

    public StarterForMeal(String name, int quantity, double itemPerPrice,pricingStrategy pricingStrategy) {
        this.name = name;
        this.quantity = quantity;
        this.itemPerPrice = itemPerPrice;
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(){
        return pricingStrategy.priceOfAnItem(itemPerPrice, quantity);
    }

    @Override
    public String toString() {
        return "StarterForMeal{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", itemPerPrice=" + itemPerPrice +
                '}';
    }
}

interface pricingStrategy{
    double priceOfAnItem(double amount,int quantity);
}

class RegularPricingStrategy implements pricingStrategy{
    public RegularPricingStrategy() {
    }

    @Override
    public double priceOfAnItem(double amount,int quantity) {
        return amount * quantity;
    }
}

class DiscountPricingStrategy implements pricingStrategy{
    private double discountPrice;

    public DiscountPricingStrategy(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public double priceOfAnItem(double amount, int quantity) {
        return (amount*quantity)-(1-discountPrice/100);
    }
}

class FixedPricingStrategy implements pricingStrategy{
    private double fixedDiscountPrice;

    public FixedPricingStrategy(double fixedDiscountPrice) {
        this.fixedDiscountPrice = fixedDiscountPrice;
    }

    @Override
    public double priceOfAnItem(double amount, int quantity) {
        return (amount * quantity) - fixedDiscountPrice;
    }
}


class MainCourseForMeal{
    private String mealName;
    private int quantiyy;
    private double pricePerQuantity;
    private pricingStrategy pricingStrategy;

    public MainCourseForMeal(String mealName, int quantiyy, double pricePerQuantity,pricingStrategy pricingStrategy) {
        this.mealName = mealName;
        this.quantiyy = quantiyy;
        this.pricePerQuantity = pricePerQuantity;
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(){
        return pricingStrategy.priceOfAnItem(pricePerQuantity,quantiyy);
    }

    @Override
    public String toString() {
        return "MainCourseForMeal{" +
                "mealName='" + mealName + '\'' +
                ", quantiyy=" + quantiyy +
                ", pricePerQuantity=" + pricePerQuantity +
                '}';
    }
}


class MealBuilderCourse{
    private MainCourseForMeal mainCourseForMeal;
    private DessertForMeal dessertForMeal;
    private StarterForMeal starterForMeal;
    private pricingStrategy pricingStrategy;



    public MealBuilderCourse setMainCourseForMeal(MainCourseForMeal mainCourseForMeal) {
        this.mainCourseForMeal = mainCourseForMeal;
        return this;
    }

    public MealBuilderCourse setDessertForMeal(DessertForMeal dessertForMeal) {
        this.dessertForMeal = dessertForMeal;
        return this;
    }

    public MealBuilderCourse setStarterForMeal(StarterForMeal starterForMeal) {
        this.starterForMeal = starterForMeal;
        return this;
    }

    public MealCourse build(){
        return new MealCourse(mainCourseForMeal,dessertForMeal, starterForMeal);
    }
}

public class StrategyDesignPattern {

    public static void main(String[] args) {
        pricingStrategy pricingStrategyAmount = new FixedPricingStrategy(50);
        pricingStrategy pricingStrategyReqularAmount = new RegularPricingStrategy();
        pricingStrategy pricingStrategyDiscount = new DiscountPricingStrategy(10);

        MainCourseForMeal mainCourseMeal = new MainCourseForMeal("Pizza",2,100,pricingStrategyAmount);
        DessertForMeal dessertForMeal = new DessertForMeal("jamun",10,25,pricingStrategyAmount);
        StarterForMeal starterForMeal = new StarterForMeal("bread",10,50,pricingStrategyDiscount);

        MealCourse mealCouse = new MealBuilderCourse()
                .setMainCourseForMeal(mainCourseMeal)
                .setDessertForMeal(dessertForMeal)
                .setStarterForMeal(starterForMeal)
                .build();

        System.out.println("Total Price for all the items: "+mealCouse.getTotalPrice());


    }
}
