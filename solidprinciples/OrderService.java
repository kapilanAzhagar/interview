package solidPrinciples;

public class OrderService {
    private PaymentProcessor processor;
    private Shipping shipping;
    private Notifier notifier;

    public OrderService(PaymentProcessor processor, Shipping shipping, Notifier notifier){
        this.processor = processor;
        this.shipping = shipping;
        this.notifier = notifier;
    }

    public void processOrder(Order order){
        processor.performPayment(order);
        shipping.ship(order);
        notifier.sendMessage("Message sent");
    }

}
