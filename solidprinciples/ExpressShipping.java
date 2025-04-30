package solidPrinciples;

public class ExpressShipping extends Shipping{
    @Override
    void ship(Order order) {
        System.out.println("Express Shipping happening:"+order.getOrderId());
    }
}
