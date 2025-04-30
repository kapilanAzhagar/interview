package solidPrinciples;

public class EmailNotifier implements Notifier{
    @Override
    public void sendMessage(String message) {
        System.out.println("Email notification");
    }
}
