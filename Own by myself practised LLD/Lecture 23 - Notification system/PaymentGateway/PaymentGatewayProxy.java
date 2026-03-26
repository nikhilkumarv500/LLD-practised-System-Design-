package PaymentGateway;

import Model.PaymentRequest;

public class PaymentGatewayProxy {

    IPaymentGateway iPaymentGateway;

    public PaymentGatewayProxy(IPaymentGateway iPaymentGateway) {
        this.iPaymentGateway = iPaymentGateway;
    }

    public void processPaymentThroughProxy(PaymentRequest paymentRequest, int retries) {
        boolean paymentSuccess = false;
        int attempt = 1;

        while(retries-- > 0) {
            System.out.println("Payment Attempt = " + attempt);
            paymentSuccess = iPaymentGateway.processPayment(paymentRequest);
            if(paymentSuccess) break;
            attempt++;
        }
        if(paymentSuccess) {
            System.out.println("Payment success full with attempt = " + attempt);
        } else {
            System.out.println("Payment failed");
        }
    }

    

}
