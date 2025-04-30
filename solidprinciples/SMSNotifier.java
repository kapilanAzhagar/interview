package solidPrinciples;

public class SMSNotifier implements Notifier{
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS notification for customer");
    }
}
