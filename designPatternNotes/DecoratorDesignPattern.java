package designPatterns;

// Order | BaseOrder | BaseDecorator | Gift-wrap Decorator | express Decorator
//The customer will add the extra features on top of the basic order like gift wrapping+express delivery

interface Order{
    String getDescription();
    double getCost();
}

class BaseOrder implements Order{
    @Override
    public String getDescription() {
        return "Basic Order";
    }
    @Override
    public double getCost() {
        return 500;
    }
}

abstract class OrderDecorator implements Order{
    protected Order order;

    public OrderDecorator(Order order){
        this.order = order;
    }

    @Override
    public String getDescription() {
        System.out.println("Order decorator");
        return order.getDescription();
    }
    @Override
    public double getCost() {
        return order.getCost();
    }
}

class GiftWrapDecorator extends OrderDecorator{
    public GiftWrapDecorator(Order order) {
        super(order);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " + Gift Wrap";
    }
    @Override
    public double getCost() {
        return super.order.getCost()+50;
    }
}


public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Order order = new BaseOrder();
        System.out.println(order.getDescription());
        System.out.println(order.getCost());

        order = new GiftWrapDecorator(order);
        System.out.println(order.getDescription());
        System.out.println(order.getCost());

    }
}
