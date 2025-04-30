package solidPrinciples;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void performPayment(Order order) {
        System.out.println("CC payment processing:"+order.getOrderId());
    }
}
