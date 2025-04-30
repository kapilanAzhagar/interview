package solidPrinciples;

public class PayPalProcessor implements PaymentProcessor
{
    @Override
    public void performPayment(Order order) {
        System.out.println("PayPal processing for order:"+order.getOrderId());
    }
}
