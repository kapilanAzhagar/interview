package solidPrinciples;

public class StandardShipping extends Shipping{
    public void ship(Order order){
        System.out.println("standard shipping:"+order.getOrderId());
    }
}
