package designPatterns;
//Encapusulates the object creation logic and return different implementataions based on user input.


interface Payment{
    void pay(int amount);
}

class CreditCardPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Credit card payment:"+amount);
    }
}

class PayPalPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Paypal Payment amount: "+amount);
    }
}

class PaymentFactory{
    public static Payment getPayment(String type){
        switch(type){
            case "CC": return new CreditCardPayment();
            case "PayPal": return new PayPalPayment();
            default: throw new IllegalArgumentException("Unknown Paymenttype");
        }
    }
}

public class FactoryDesignPattern {

    public static void main(String[] args){
        Payment payment = PaymentFactory.getPayment("PayPal");
        payment.pay(50);
    }
}
