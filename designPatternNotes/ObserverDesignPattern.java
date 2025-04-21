package designPatterns;

import solidPrinciples.Notifier;

import java.util.ArrayList;
import java.util.List;

// The observer pattern allows the object to maintain the subscriper and update them if any changes are happened.
//Example: customer subscribes the notifications for product stock available.
interface Observer{
    void update (String productName);
}

class EmailSubscriber implements Observer{
    String email = "";

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String productName) {
        System.out.println("Email notification for stock changes: "+email);
    }

    @Override
    public String toString() {
        return "EmailSubscriber{" +
                "email='" + email + '\'' +
                '}';
    }
}

class SMSSubscriber implements Observer{
    String mobileNo = "8892000361";

    public SMSSubscriber(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public void update(String productName) {
        System.out.println("SMS notification for mobile number: "+mobileNo);
    }

    @Override
    public String toString() {
        return "SMSSubscriber{" +
                "mobileNo='" + mobileNo + '\'' +
                '}';
    }
}

interface ProductNotifier{
    void addNotifier(Observer observer);
    void removeNotifier(Observer observer);
    void sendNotification();
}

class ProductItem implements ProductNotifier{
    private String productName;
    private String productDesc;
    private double price;
    private boolean isStockAvailable;
    List<Observer> notifierList = new ArrayList<>();

    public ProductItem(String productName){
        this.productName = productName;
        System.out.println("product created");
    }

    public void setStockAvailable(boolean stockAvailable) {
        System.out.println("product initiating notification stockAvailable: "+stockAvailable);
        if(stockAvailable){
            System.out.println("product initiating notification");
            sendNotification();
        }
    }

    @Override
    public void addNotifier(Observer observer) {
        System.out.println("product initiating addNotifier"+observer);
                notifierList.add(observer);
    }

    @Override
    public void removeNotifier(Observer observer) {
        if(isStockAvailable){
            notifierList.remove(observer);
        }
    }

    @Override
    public void sendNotification() {
        notifierList.forEach(observer -> observer.update(productName));

    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", isStockAvailable=" + isStockAvailable +
                ", notifierList=" + notifierList +
                '}';
    }
}


public class ObserverDesignPattern {

    public static void main(String[] args) {
        ProductItem productItem = new ProductItem("Laptop");
        Observer emailSubscriber = new EmailSubscriber("kapil.rvs");
        Observer smsSubscriber = new SMSSubscriber("88920000383");

        productItem.addNotifier(emailSubscriber);
        productItem.addNotifier(smsSubscriber);

        productItem.setStockAvailable(true);


    }
}
