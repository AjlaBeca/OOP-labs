package Week13;

interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}

interface PaymentFactory {
    Payment createPayment();
}
class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}

// Main class
public class FactoryMethod {
    public static void main(String[] args) {

        PaymentFactory creditCardPaymentFactory = new CreditCardPaymentFactory();
        PaymentFactory payPalPaymentFactory = new PayPalPaymentFactory();

        Payment creditCardPayment = creditCardPaymentFactory.createPayment();
        Payment payPalPayment = payPalPaymentFactory.createPayment();

        creditCardPayment.processPayment();
        payPalPayment.processPayment();
    }
}
