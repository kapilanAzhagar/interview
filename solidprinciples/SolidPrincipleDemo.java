package solidPrinciples;

public class SolidPrincipleDemo {

    public static void main(String[] args) {
        Order order = new Order(3454,899);
        PaymentProcessor processor = new CreditCardPayment();
        Shipping shipping = new ExpressShipping();
        Notifier notifier = new SMSNotifier();

        OrderService orderService = new OrderService(processor,shipping,notifier);
        orderService.processOrder(order);

    }
}
