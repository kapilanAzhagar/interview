package designPatterns;

class StripePayment{
    void stripePayment(double amount){
        System.out.println("Performing the strip payment:"+amount);
    }
}

class PayPalPaymentClient{
    void paypalPayment(double amount){
        System.out.println("Performing the paypal payment:"+amount);
    }
}

//own payment gateway
interface PaymentGateway{
    void pay(double amount);
}

class PayPalAdapter implements PaymentGateway{
    PayPalPaymentClient payPalPaymentClient = new PayPalPaymentClient();
    @Override
    public void pay(double amount) {
        payPalPaymentClient.paypalPayment(amount);
    }
}

class StripeAdapter implements PaymentGateway{
    StripePayment stripePayment = new StripePayment();
    @Override
    public void pay(double amount) {
        stripePayment.stripePayment(amount);
    }
}


public class AdapterDesignPattern {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PayPalAdapter();
        paymentGateway.pay(1000);
        PaymentGateway paymentGateway1 = new StripeAdapter();
        paymentGateway1.pay(400);

    }
}
