package PaymentGateway;

import BankingSystem.PayTMBankingSystem;
import Model.PaymentRequest;

public class PayTMGateway extends IPaymentGateway{

    public PayTMGateway() {
        super(new PayTMBankingSystem());
    }

    @Override
    public boolean validatePayment(PaymentRequest paymentRequest) {
        // System.out.println("validate paymment (PayTMGateway)= " + paymentRequest.getCurrency());
        if(paymentRequest.getAmount()<=0 || !paymentRequest.getCurrency().equals("INR")) return false;
        return true;
    }
    

    @Override
    public boolean initiatePayment(PaymentRequest paymentRequest) {
        // System.out.println("Inittiate payment + PayTMGateway");
        boolean PaymentFromGateway = bankingSystem.processPaymentInBankingSystem(paymentRequest.getAmount());
        return PaymentFromGateway;
    }
    

    @Override
    public boolean confirmPayment(PaymentRequest paymentRequest) {
        // just as an example
        return true;
    }

    @Override
    public void printPaymentGatewayType() {
        System.out.println("PayTMGateway");
        
    }

    
    
    
}
